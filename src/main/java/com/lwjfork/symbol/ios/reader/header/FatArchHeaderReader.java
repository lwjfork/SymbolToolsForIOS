package com.lwjfork.symbol.ios.reader.header;

import com.lwjfork.symbol.ios.model.header.FatArchHeader;
import com.lwjfork.symbol.ios.reader.base.BaseAssignBytesCountReader;

import java.io.IOException;
import java.io.RandomAccessFile;

public class FatArchHeaderReader extends BaseAssignBytesCountReader<FatArchHeader> {

    public FatArchHeaderReader(long offset, RandomAccessFile accessFile) {
        super(offset,  accessFile, 20);
    }


    private long readCpuType() throws IOException {
        return read4Bytes2Long();
    }

    private long readCpuSubType() throws IOException {
        return read4Bytes2Long();
    }


    private long readSymbolsOffset() throws IOException {
        return read4Bytes2Long();
    }

    private long readSymbolsSize() throws IOException {
        return read4Bytes2Long();
    }


    private long readSymbolsAlign() throws IOException {
        return (long) Math.pow(2, read4Bytes2Long());

    }


    @Override
    public FatArchHeader read() throws IOException {
        FatArchHeader archHeader = new FatArchHeader();
        archHeader.cpuType = readCpuType();
        archHeader.cpuSubType = readCpuSubType();
        archHeader.symbolsOffset = readSymbolsOffset();
        archHeader.symbolsSize = readSymbolsSize();
        archHeader.symbolsAlign = readSymbolsAlign();
        archHeader.useBytesCount = bytesCount;
        return archHeader;
    }
}
