package com.lwjfork.symbol.ios.reader.arm.command;

import com.lwjfork.symbol.ios.mapper.arm.ARMLcMapper;
import com.lwjfork.symbol.ios.model.arm.command.ARMLcSegment;
import com.lwjfork.symbol.ios.reader.common.base.BaseAssignBytesCountReader;
import com.lwjfork.symbol.ios.vo.arm.command.ARMLcSectionHeaderBytes;
import com.lwjfork.symbol.ios.vo.arm.command.ARMLcSegmentBytes;
import com.lwjfork.symbol.tools.mapper.Bytes2LongMapper;

import java.io.IOException;
import java.io.RandomAccessFile;

public class ARMLcSegmentReader extends BaseAssignBytesCountReader<ARMLcSegment, ARMLcSegmentBytes> {


    public ARMLcSegmentReader(long offset, RandomAccessFile accessFile, long maxBytesCount) {
        super(offset, accessFile, maxBytesCount);
    }


    @Override
    protected ARMLcSegment convertBytes2Model(ARMLcSegmentBytes bytes) {
        return ARMLcMapper.INSTANCE.bytes2Model(bytes);
    }


    @Override
    protected void writeOffsetAndBytesCount(ARMLcSegmentBytes bytes) {
        bytes.offsetOfBytes = bytes.commandSize.offset;
        bytes.useBytesCount = Bytes2LongMapper.INSTANCE.byte4ToLong(bytes.command);
    }


    @Override
    protected ARMLcSegmentBytes readBytes() throws IOException {
        accessFile.seek(offset);
        ARMLcSegmentBytes lcSegmentBytes = new ARMLcSegmentBytes();
        lcSegmentBytes.command = read4Bytes(true);
        lcSegmentBytes.commandSize = read4Bytes(true);
        lcSegmentBytes.segmentName = read16Bytes(true);
        lcSegmentBytes.vmAddress = read4Bytes(true);
        lcSegmentBytes.vmSize = read4Bytes(true);
        lcSegmentBytes.fileOffset = read4Bytes(true);
        lcSegmentBytes.fileSize = read4Bytes(true);
        lcSegmentBytes.maxVmProtection = read4Bytes(true);
        lcSegmentBytes.initialVmProtection = read4Bytes(true);
        lcSegmentBytes.sectionsNum = read4Bytes(true);
        lcSegmentBytes.flags = read4Bytes(true);


        long sectionNum = Bytes2LongMapper.INSTANCE.byte4ToLong(lcSegmentBytes.sectionsNum);

        if (sectionNum > 0L) {
            long sectionHeaderOffset = offset + bytesCount;
            for (long i = 0; i < sectionNum; i++) {
                ARMLcSectionHeaderBytes sectionHeaderBytes = new ARMLcSectionHeaderReader(sectionHeaderOffset, accessFile).readBytesFinal();
                lcSegmentBytes.sectionHeaders.add(sectionHeaderBytes);
                sectionHeaderOffset = sectionHeaderOffset + sectionHeaderBytes.useBytesCount;
            }
        }
        return lcSegmentBytes;
    }
}
