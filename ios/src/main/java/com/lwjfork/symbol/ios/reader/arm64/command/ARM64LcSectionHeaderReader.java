package com.lwjfork.symbol.ios.reader.arm64.command;

import com.lwjfork.symbol.ios.mapper.arm64.ARM64LcMapper;
import com.lwjfork.symbol.ios.model.arm64.command.ARM64LcSectionHeader;
import com.lwjfork.symbol.ios.reader.common.base.BaseAssignBytesCountReader;
import com.lwjfork.symbol.ios.vo.arm64.command.ARM64LcSectionHeaderBytes;

import java.io.IOException;
import java.io.RandomAccessFile;


public class ARM64LcSectionHeaderReader extends BaseAssignBytesCountReader<ARM64LcSectionHeader, ARM64LcSectionHeaderBytes> {


    public ARM64LcSectionHeaderReader(long offset, RandomAccessFile accessFile) {
        super(offset, accessFile, 80);

    }

    @Override
    protected void writeOffsetAndBytesCount(ARM64LcSectionHeaderBytes bytes) {
        bytes.offsetOfBytes = getOffsetHexStr();
        bytes.useBytesCount = maxBytesCount;
    }

    @Override
    protected ARM64LcSectionHeader convertBytes2Model(ARM64LcSectionHeaderBytes bytes) {
        return ARM64LcMapper.INSTANCE.bytes2Model(bytes);
    }

    @Override
    protected ARM64LcSectionHeaderBytes readBytes() throws IOException {
        accessFile.seek(offset);
        ARM64LcSectionHeaderBytes bytes = new ARM64LcSectionHeaderBytes();
        bytes.sectionName = read16Bytes(true);
        bytes.segmentName = read16Bytes(true);
        bytes.address = read8Bytes(true);
        bytes.size = read8Bytes(true);
        bytes.offset = read4Bytes(true);
        bytes.alignment = read4Bytes(true);
        bytes.rlOffset = read4Bytes(true);
        bytes.rlNum = read4Bytes(true);
        bytes.flags = read4Bytes(true);
        bytes.reserved1OrIndexOfIS = read4Bytes(true);
        bytes.reserved2OrSizeOfStubs = read4Bytes(true);
        bytes.reserved3 = read4Bytes(true);
        return bytes;
    }
}