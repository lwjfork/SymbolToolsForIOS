package com.lwjfork.symbol.ios.reader.base;

import com.lwjfork.symbol.ios.model.base.BaseMachHeader;

import java.io.IOException;
import java.io.RandomAccessFile;

public abstract class BaseMachHeaderReader<T extends BaseMachHeader> extends BaseReader<T> {

    public BaseMachHeaderReader(long offset, RandomAccessFile accessFile) {
        super(offset, accessFile);
    }

    protected void readBaseHeader(T header) throws IOException {
        header.magicNum = readMagicNum();
        header.cpuType = readCpuType();
        header.cpuSubType = readCpuSubType();
        header.fileType = readFileType();
        header.commandsNum = readCommandNum();
        header.commandSize = readCommandSize();
        header.flags = readFlags();
    }


    /**
     * 读取 magicNumber
     *
     * @return
     */
    private long readMagicNum() throws IOException {
        return read4Bytes2Long();
    }


    private long readCpuType() throws IOException {
        return read4Bytes2Long(true);
    }

    private long readCpuSubType() throws IOException {
        return read4Bytes2Long(true);
    }


    private long readFileType() throws IOException {
        return read4Bytes2Long(true);
    }

    private long readCommandNum() throws IOException {
        return read4Bytes2Long(true);
    }

    private long readCommandSize() throws IOException {
        return read4Bytes2Long(true);
    }

    private long readFlags() throws IOException {
        return read4Bytes2Long(true);
    }


}
