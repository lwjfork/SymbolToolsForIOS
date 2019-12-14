package com.lwjfork.symbol.ios.reader.common.base;

import com.lwjfork.symbol.ios.model.common.base.BaseMachHeader;
import com.lwjfork.symbol.ios.vo.arm.mach_header.ARMMachHeaderBytes;
import com.lwjfork.symbol.tools.model.Byte4;

import java.io.IOException;
import java.io.RandomAccessFile;

public abstract class BaseMachHeaderReader<T extends BaseMachHeader, V extends ARMMachHeaderBytes> extends BaseAssignBytesCountReader<T, V> {



    public BaseMachHeaderReader(long offset, RandomAccessFile accessFile, long maxBytesCount) {
        super(offset, accessFile, maxBytesCount);
    }


    protected void readCommon(V machHeaderBytes) throws IOException {
        machHeaderBytes.magicNum = read4Bytes();
        machHeaderBytes.cpuType = read4Bytes(true);
        machHeaderBytes.cpuSubType = read4Bytes(true);
        machHeaderBytes.fileType = read4Bytes(true);
        machHeaderBytes.commandsNum = read4Bytes(true);
        machHeaderBytes.commandSize = read4Bytes(true);
        machHeaderBytes.flags = read4Bytes();
    }


    @Override
    protected void writeOffsetAndBytesCount(V bytes) {
        bytes.offset = bytes.magicNum.offset;
        bytes.useBytesCount = bytesCount;
    }


}
