package com.lwjfork.symbol.ios.reader.arm64.command;

import com.lwjfork.symbol.ios.mapper.arm64.ARM64LcMapper;
import com.lwjfork.symbol.ios.model.arm64.command.ARM64LcSegment;
import com.lwjfork.symbol.ios.reader.common.command.BaseLcSegmentReader;
import com.lwjfork.symbol.ios.vo.arm64.command.ARM64LcSegmentBytes;
import com.lwjfork.symbol.tools.mapper.Bytes2LongMapper;

import java.io.IOException;
import java.io.RandomAccessFile;

public class ARM64LcSegmentReader extends BaseLcSegmentReader<ARM64LcSegment, ARM64LcSegmentBytes> {

    ARM64LcMapper lcMapper = ARM64LcMapper.INSTANCE;
    Bytes2LongMapper bytesMapper = Bytes2LongMapper.INSTANCE;

    public ARM64LcSegmentReader(long offset, RandomAccessFile accessFile, long maxBytesCount) {
        super(offset, accessFile, maxBytesCount);
    }


    @Override
    protected void writeOffsetAndBytesCount(ARM64LcSegmentBytes bytes) {
        bytes.offset = bytes.command.offset;
        bytes.useBytesCount = bytesMapper.byte4ToLong(bytes.command);
    }

    @Override
    protected void readSpecial(ARM64LcSegmentBytes lcSegmentBytes) throws IOException {
        lcSegmentBytes.VMAddress = read8Bytes();
        lcSegmentBytes.VMSize = read8Bytes();
        lcSegmentBytes.fileOffset = read8Bytes();
        lcSegmentBytes.fileSize = read8Bytes();
    }

    @Override
    protected ARM64LcSegment convertBytes2Model(ARM64LcSegmentBytes bytes) {
        return lcMapper.bytes2Model(bytes);
    }

    @Override
    protected ARM64LcSegmentBytes readBytes() throws IOException {
        accessFile.seek(offset);
        ARM64LcSegmentBytes lcSegmentBytes = new ARM64LcSegmentBytes();
        readSpecialBefore(lcSegmentBytes);
        readSpecial(lcSegmentBytes);
        readSpecialAfter(lcSegmentBytes);
        return lcSegmentBytes;
    }
}
