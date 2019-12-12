package com.lwjfork.symbol.ios.reader.header;

import com.lwjfork.symbol.ios.model.header.FatArchHeader;
import com.lwjfork.symbol.ios.model.header.FatHeader;
import com.lwjfork.symbol.ios.reader.base.BaseReader;
import com.lwjfork.symbol.tools.uitls.ByteUtil;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 读取 Fat header 信息
 */
public class FatHeaderReader extends BaseReader<FatHeader> {

    public FatHeaderReader(RandomAccessFile accessFile) {
        super(0,  accessFile);
    }


    @Override
    public FatHeader read() throws IOException {
        accessFile.seek(getStartReadIndex());
        FatHeader fatHeader = new FatHeader();
        fatHeader.magicNum = readMagicNum();
        long archNum = readArchNum();
        fatHeader.archNum = archNum;
        for (long i = 0; i < archNum; i++) {
            FatArchHeaderReader fatArchHeaderReader = new FatArchHeaderReader(currentIndex, accessFile);
            FatArchHeader fatArchHeader = fatArchHeaderReader.read();
            currentIndex = fatArchHeaderReader.getCurrentIndex();
            fatHeader.arches.add(fatArchHeader);
            bytesCount = bytesCount + fatArchHeader.useBytesCount;
        }
        fatHeader.useBytesCount = bytesCount;
        return fatHeader;
    }


    /**
     * 读取 magicNumber
     *
     * @return
     */
    public long readMagicNum() throws IOException {
        byte[] magiNumBytes = read4Bytes();
        return ByteUtil.bytes2Long(magiNumBytes);
    }

    /**
     * 读取 arch num
     *
     * @return
     */
    public long readArchNum() throws IOException {
        byte[] archNumBytes = read4Bytes();
        return ByteUtil.bytes2Long(archNumBytes);
    }

}
