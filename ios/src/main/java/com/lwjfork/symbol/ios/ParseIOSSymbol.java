package com.lwjfork.symbol.ios;

import com.lwjfork.symbol.ios.constant.FatMagicNum;
import com.lwjfork.symbol.ios.constant.MachMagicNums;
import com.lwjfork.symbol.ios.model.arm.ARMSymbol;
import com.lwjfork.symbol.ios.model.arm64.ARM64Symbol;
import com.lwjfork.symbol.ios.model.common.header.FatArchHeader;
import com.lwjfork.symbol.ios.model.common.header.FatHeader;
import com.lwjfork.symbol.ios.reader.arm.ARMSymbolReader;
import com.lwjfork.symbol.ios.reader.arm64.ARM64SymbolReader;
import com.lwjfork.symbol.ios.reader.fat.FatHeaderReader;
import com.lwjfork.symbol.tools.mapper.Bytes2LongMapper;
import com.lwjfork.symbol.tools.model.Byte4;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;

public class ParseIOSSymbol {


    public void parseSymbol(String filePath) {
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = new RandomAccessFile(filePath, "r");
            byte[] bytes = new byte[4];
            randomAccessFile.read(bytes);
            Byte4 magicBytes = new Byte4(bytes, "0");
            long magicNumber = Bytes2LongMapper.INSTANCE.byte4ToLong(magicBytes);
            if (magicNumber == FatMagicNum.FAT_MAGIC) {
                FatHeader fatHeader = new FatHeaderReader(randomAccessFile).read();
                // 解析每一种架构的数据类型
                List<FatArchHeader> fatArchHeaders = fatHeader.arches;
                for (FatArchHeader fatArchHeader : fatArchHeaders) {
                    parseSymbol(fatArchHeader, randomAccessFile);
                }
            } else {
                parseSymbol(magicBytes, randomAccessFile, 0, randomAccessFile.length());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    private void parseSymbol(FatArchHeader fatArchHeader, RandomAccessFile accessFile) throws IOException {
        long offset = fatArchHeader.symbolsOffset;
        long bytesCount = fatArchHeader.symbolsSize;
        accessFile.seek(offset);
        byte[] bytes = new byte[4];
        accessFile.read(bytes);
        Byte4 magicBytes = new Byte4(bytes, Long.toHexString(offset));
        parseSymbol(magicBytes, accessFile, offset, bytesCount);
    }


    private void parseSymbol(Byte4 magicBytes, RandomAccessFile accessFile, long offset, long bytesCount) throws IOException {
        long magicNumber = Bytes2LongMapper.INSTANCE.byte4ToLong(magicBytes);
        if (magicNumber == MachMagicNums.MH_MAGIC) {
            parseARMSymbol(magicBytes, accessFile, bytesCount);
        } else if (magicNumber == MachMagicNums.MH_MAGIC_64) {
            parseARM64Symbol(magicBytes, accessFile, bytesCount);
        }
    }


    /**
     * 解析 symbol 区域
     *
     * @param magicBytes symbol 的 magic number 信息
     * @param accessFile dsym 文件
     * @param bytesCount symbol的字节数
     * @throws IOException
     */
    private void parseARMSymbol(Byte4 magicBytes, RandomAccessFile accessFile, long bytesCount) throws IOException {
        ARMSymbolReader symbolReader = new ARMSymbolReader(magicBytes, accessFile, bytesCount);
        ARMSymbol symbol = symbolReader.read();
        System.out.println(symbol.stringTable);
    }

    /**
     * 解析 symbol 区域
     *
     * @param magicBytes symbol 的 magic number 信息
     * @param accessFile dsym 文件
     * @param bytesCount symbol的字节数
     * @throws IOException
     */
    private void parseARM64Symbol(Byte4 magicBytes, RandomAccessFile accessFile, long bytesCount) throws IOException {
        ARM64SymbolReader symbolReader = new ARM64SymbolReader(magicBytes, accessFile, bytesCount);
        ARM64Symbol symbol = symbolReader.read();
        System.out.println(symbol.stringTable);
    }
}
