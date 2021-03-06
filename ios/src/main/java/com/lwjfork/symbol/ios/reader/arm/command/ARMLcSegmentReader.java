package com.lwjfork.symbol.ios.reader.arm.command;

import com.lwjfork.symbol.ios.mapper.arm.ARMLcMapper;
import com.lwjfork.symbol.ios.model.arm.command.ARMLcSegment;
import com.lwjfork.symbol.ios.reader.common.base.BaseAssignBytesCountReader;
import com.lwjfork.symbol.ios.vo.arm.ARMSymbolBytes;
import com.lwjfork.symbol.ios.vo.arm.command.ARMLcSectionHeaderBytes;
import com.lwjfork.symbol.ios.vo.arm.command.ARMLcSegmentBytes;
import com.lwjfork.symbol.tools.mapper.Bytes2LongMapper;

import java.io.IOException;
import java.io.RandomAccessFile;

public class ARMLcSegmentReader extends BaseAssignBytesCountReader<ARMLcSegment, ARMLcSegmentBytes> {

    ARMSymbolBytes armSymbolBytes;

    public ARMLcSegmentReader(long offset, RandomAccessFile accessFile, long maxBytesCount, ARMSymbolBytes armSymbolBytes) {
        super(offset, accessFile, maxBytesCount);
        this.armSymbolBytes = armSymbolBytes;
    }


    @Override
    protected ARMLcSegment convertBytes2Model(ARMLcSegmentBytes bytes) {
        return ARMLcMapper.INSTANCE.bytes2ModelSegment(bytes);
    }


    @Override
    protected void writeOffsetAndBytesCount(ARMLcSegmentBytes bytes) {
        bytes.offsetHexStrOfBytes = bytes.command.offsetHexStrOfBytes;
        bytes.offsetOfBytes = bytes.command.offsetOfBytes;
        bytes.useBytesCount = Bytes2LongMapper.INSTANCE.byte4ToLong(bytes.command);
    }


    @Override
    protected ARMLcSegmentBytes readBytes() throws IOException {
        accessFile.seek(offset);
        ARMLcSegmentBytes lcSegmentBytes = new ARMLcSegmentBytes();
        lcSegmentBytes.command = read4Bytes(true);
        lcSegmentBytes.commandSize = read4Bytes(true);
        lcSegmentBytes.segmentName = read16Bytes();
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
                ARMLcSectionHeaderBytes sectionHeaderBytes = new ARMLcSectionHeaderReader(sectionHeaderOffset, accessFile,armSymbolBytes).readBytesFinal();
                lcSegmentBytes.sectionHeaders.add(sectionHeaderBytes);
                sectionHeaderOffset = sectionHeaderOffset + sectionHeaderBytes.useBytesCount;
            }
        }
        return lcSegmentBytes;
    }
}
