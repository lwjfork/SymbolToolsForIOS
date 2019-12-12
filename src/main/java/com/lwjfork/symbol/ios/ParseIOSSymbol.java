package com.lwjfork.symbol.ios;

import com.lwjfork.symbol.ios.constant.MagicNumberType;
import com.lwjfork.symbol.ios.model.base.BaseMachHeader;
import com.lwjfork.symbol.ios.model.base.BaseSymbol;
import com.lwjfork.symbol.ios.model.header.ARM_64_MachHeader;
import com.lwjfork.symbol.ios.model.header.ARM_V7_MachHeader;
import com.lwjfork.symbol.ios.model.header.FatArchHeader;
import com.lwjfork.symbol.ios.model.header.FatHeader;
import com.lwjfork.symbol.ios.reader.header.ARM_64_MachHeaderReader;
import com.lwjfork.symbol.ios.reader.header.ARM_V7_MachHeaderReader;
import com.lwjfork.symbol.ios.reader.header.FatHeaderReader;
import com.lwjfork.symbol.ios.reader.header.MachHeaderReader;
import com.lwjfork.symbol.ios.reader.symbol.ARM_V64_SymbolReader;
import com.lwjfork.symbol.ios.reader.symbol.ARM_V7_SymbolReader;
import com.lwjfork.symbol.tools.uitls.ByteUtil;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class ParseIOSSymbol {




    ArrayList<BaseSymbol> symbols = new ArrayList<>();


    public void parseSymbol(String filePath) {
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = new RandomAccessFile(filePath, "r");
            byte[] bytes = new byte[4];
            randomAccessFile.read(bytes);
            long magicNumber = ByteUtil.bytes2Long(bytes);
            if (magicNumber == MagicNumberType.FAT_MAGIC_NUMBER) {
                FatHeader fatHeader = new FatHeaderReader(randomAccessFile).read();
                // 解析每一种架构的数据类型
                List<FatArchHeader> fatArchHeaders = fatHeader.arches;
                for (FatArchHeader fatArchHeader : fatArchHeaders) {
                    MachHeaderReader machHeaderReader = new MachHeaderReader(fatArchHeader, randomAccessFile);
                    BaseMachHeader baseMachHeader = machHeaderReader.read();
                    parseSymbol(baseMachHeader, randomAccessFile, fatArchHeader.symbolsOffset, fatArchHeader.symbolsSize);
                }
            } else if (magicNumber == MagicNumberType.MH64_MAGIC_NUMBER) {
                ARM_64_MachHeaderReader machHeaderReader = new ARM_64_MachHeaderReader(randomAccessFile);
                ARM_64_MachHeader baseMachHeader = machHeaderReader.read();
                parseSymbol(baseMachHeader, randomAccessFile, 0, randomAccessFile.length());
            } else if (magicNumber == MagicNumberType.MH_MAGIC_NUMBER) {
                ARM_V7_MachHeaderReader machHeaderReader = new ARM_V7_MachHeaderReader(randomAccessFile);
                ARM_V7_MachHeader baseMachHeader = machHeaderReader.read();
                parseSymbol(baseMachHeader, randomAccessFile, 0, randomAccessFile.length());
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


    private void parseSymbol(BaseMachHeader machHeader, RandomAccessFile accessFile, long offset, long bytesCount) throws IOException {

        if (machHeader.magicNum == MagicNumberType.MH64_MAGIC_NUMBER) {
            parseSymbol((ARM_64_MachHeader) machHeader, accessFile, offset, bytesCount);
        } else if (machHeader.magicNum == MagicNumberType.MH_MAGIC_NUMBER) {
            parseSymbol((ARM_V7_MachHeader) machHeader, accessFile, offset, bytesCount);
        }
    }

    private void parseSymbol(ARM_V7_MachHeader machHeader, RandomAccessFile accessFile, long offset, long bytesCount) throws IOException {

        ARM_V7_SymbolReader symbolReader = new ARM_V7_SymbolReader(machHeader, offset, accessFile, bytesCount);
        symbolReader.read();

    }


    private void parseSymbol(ARM_64_MachHeader machHeader, RandomAccessFile accessFile, long offset, long bytesCount) throws IOException {
        ARM_V64_SymbolReader symbolReader = new ARM_V64_SymbolReader(machHeader, offset, accessFile, bytesCount);
        symbolReader.read();
    }
}
