package com.lwjfork.symbol.ios.reader.arm.command;

import com.lwjfork.symbol.ios.mapper.arm.ARMLcMapper;
import com.lwjfork.symbol.ios.model.arm.command.ARMLcSegment;
import com.lwjfork.symbol.ios.reader.common.command.BaseLcSegmentReader;
import com.lwjfork.symbol.ios.vo.arm.command.ARMLcSegmentBytes;
import com.lwjfork.symbol.tools.mapper.Bytes2LongMapper;

import java.io.IOException;
import java.io.RandomAccessFile;

public class ARMLcSegmentReader extends BaseLcSegmentReader<ARMLcSegment, ARMLcSegmentBytes> {


    ARMLcMapper lcMapper = ARMLcMapper.INSTANCE;
    Bytes2LongMapper bytesMapper = Bytes2LongMapper.INSTANCE;

    public ARMLcSegmentReader(long offset, RandomAccessFile accessFile, long maxBytesCount) {
        super(offset, accessFile, maxBytesCount);
    }


    @Override
    protected void readSpecial(ARMLcSegmentBytes lcSegmentBytes) throws IOException {
        lcSegmentBytes.VMAddress = read4Bytes();
        lcSegmentBytes.VMSize = read4Bytes();
        lcSegmentBytes.fileOffset = read4Bytes();
        lcSegmentBytes.fileSize = read4Bytes();
    }

    @Override
    protected ARMLcSegment convertBytes2Model(ARMLcSegmentBytes bytes) {

        return lcMapper.bytes2Model(bytes);
    }


    @Override
    protected void writeOffsetAndBytesCount(ARMLcSegmentBytes bytes) {
        bytes.offset = bytes.command.offset;
        bytes.useBytesCount = bytesMapper.byte4ToLong(bytes.command);
    }

    @Override
    protected ARMLcSegmentBytes readBytes() throws IOException {
        accessFile.seek(offset);
        ARMLcSegmentBytes lcSegmentBytes = new ARMLcSegmentBytes();
        readSpecialBefore(lcSegmentBytes);
        readSpecial(lcSegmentBytes);
        readSpecialAfter(lcSegmentBytes);
        return lcSegmentBytes;
    }
}
