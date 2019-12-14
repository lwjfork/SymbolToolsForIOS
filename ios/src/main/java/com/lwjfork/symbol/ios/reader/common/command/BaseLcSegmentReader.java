package com.lwjfork.symbol.ios.reader.common.command;

import com.lwjfork.symbol.ios.reader.common.base.BaseAssignBytesCountReader;
import com.lwjfork.symbol.ios.vo.common.command.BaseLcSegmentBytes;

import java.io.IOException;
import java.io.RandomAccessFile;

public abstract class BaseLcSegmentReader<T, V extends BaseLcSegmentBytes> extends BaseAssignBytesCountReader<T, V> {


    public BaseLcSegmentReader(long offset, RandomAccessFile accessFile, long maxBytesCount) {
        super(offset, accessFile, maxBytesCount);
    }

    protected abstract void readSpecial(V lcSegmentBytes) throws IOException;




    protected void readSpecialBefore(V lcSegmentBytes) throws IOException {
        lcSegmentBytes.command = read4Bytes();
        lcSegmentBytes.commandSize = read4Bytes();
        lcSegmentBytes.segmentName = read16Bytes();
    }

    protected void readSpecialAfter(V lcSegmentBytes) throws IOException {
        lcSegmentBytes.command = read4Bytes();
        lcSegmentBytes.commandSize = read4Bytes();
        lcSegmentBytes.segmentName = read16Bytes();
        lcSegmentBytes.maxVMProtection = read4Bytes();
        lcSegmentBytes.initialVMProtection = read4Bytes();
        lcSegmentBytes.sectionsNum = read4Bytes();
        lcSegmentBytes.flags = read4Bytes();
    }


}
