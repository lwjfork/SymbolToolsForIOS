package com.lwjfork.symbol.ios.reader.arm64.command;

import com.lwjfork.symbol.ios.mapper.arm64.ARM64LcMapper;
import com.lwjfork.symbol.ios.model.arm64.command.ARM64LcSegment;
import com.lwjfork.symbol.ios.reader.common.base.BaseAssignBytesCountReader;
import com.lwjfork.symbol.ios.vo.arm64.command.ARM64LcSectionHeaderBytes;
import com.lwjfork.symbol.ios.vo.arm64.command.ARM64LcSegmentBytes;
import com.lwjfork.symbol.tools.mapper.Bytes2LongMapper;

import java.io.IOException;
import java.io.RandomAccessFile;

public class ARM64LcSegmentReader extends BaseAssignBytesCountReader<ARM64LcSegment, ARM64LcSegmentBytes> {


    public ARM64LcSegmentReader(long offset, RandomAccessFile accessFile, long maxBytesCount) {
        super(offset, accessFile, maxBytesCount);
    }


    @Override
    protected ARM64LcSegment convertBytes2Model(ARM64LcSegmentBytes bytes) {
        return ARM64LcMapper.INSTANCE.bytes2Model(bytes);
    }


    @Override
    protected void writeOffsetAndBytesCount(ARM64LcSegmentBytes bytes) {
        bytes.offsetOfBytes = bytes.commandSize.offset;
        bytes.useBytesCount = Bytes2LongMapper.INSTANCE.byte4ToLong(bytes.command);
    }

    @Override
    protected ARM64LcSegmentBytes readBytes() throws IOException {
        accessFile.seek(offset);
        ARM64LcSegmentBytes lcSegmentBytes = new ARM64LcSegmentBytes();
        lcSegmentBytes.command = read4Bytes(true);
        lcSegmentBytes.commandSize = read4Bytes(true);
        lcSegmentBytes.segmentName = read16Bytes(true);
        lcSegmentBytes.vmAddress = read8Bytes(true);
        lcSegmentBytes.vmSize = read8Bytes(true);
        lcSegmentBytes.fileOffset = read8Bytes(true);
        lcSegmentBytes.fileSize = read8Bytes(true);
        lcSegmentBytes.maxVmProtection = read4Bytes(true);
        lcSegmentBytes.initialVmProtection = read4Bytes(true);
        lcSegmentBytes.sectionsNum = read4Bytes(true);
        lcSegmentBytes.flags = read4Bytes(true);

        long sectionNum = Bytes2LongMapper.INSTANCE.byte4ToLong(lcSegmentBytes.sectionsNum);

        if (sectionNum > 0L) {
            long sectionHeaderOffset = offset + bytesCount;
            for (long i = 0; i < sectionNum; i++) {
                ARM64LcSectionHeaderBytes sectionHeaderBytes = new ARM64LcSectionHeaderReader(sectionHeaderOffset, accessFile).readBytesFinal();
                lcSegmentBytes.sectionHeaders.add(sectionHeaderBytes);
                sectionHeaderOffset = sectionHeaderOffset + sectionHeaderBytes.useBytesCount;
            }
        }

        return lcSegmentBytes;
    }
}
