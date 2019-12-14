package com.lwjfork.symbol.ios.reader.arm.command;

import com.lwjfork.symbol.ios.mapper.arm.ARMLcMapper;
import com.lwjfork.symbol.ios.model.arm.command.ARMLcSectionHeader;
import com.lwjfork.symbol.ios.reader.common.base.BaseAssignBytesCountReader;
import com.lwjfork.symbol.ios.vo.arm.ARMSymbolBytes;
import com.lwjfork.symbol.ios.vo.arm.command.ARMLcSectionHeaderBytes;

import java.io.IOException;
import java.io.RandomAccessFile;


public class ARMLcSectionHeaderReader extends BaseAssignBytesCountReader<ARMLcSectionHeader, ARMLcSectionHeaderBytes> {

    ARMSymbolBytes armSymbolBytes;

    public ARMLcSectionHeaderReader(long offset, RandomAccessFile accessFile, ARMSymbolBytes armSymbolBytes) {
        super(offset, accessFile, 68);
        this.armSymbolBytes = armSymbolBytes;
    }


    @Override
    protected void writeOffsetAndBytesCount(ARMLcSectionHeaderBytes bytes) {
        bytes.offsetHexStrOfBytes = getOffsetHexStr();
        bytes.offsetOfBytes = getOffset();
        bytes.useBytesCount = maxBytesCount;
    }

    @Override
    protected ARMLcSectionHeader convertBytes2Model(ARMLcSectionHeaderBytes bytes) {
        return ARMLcMapper.INSTANCE.bytes2Model(bytes);
    }

    @Override
    protected ARMLcSectionHeaderBytes readBytes() throws IOException {
        accessFile.seek(offset);
        ARMLcSectionHeaderBytes bytes = new ARMLcSectionHeaderBytes();
        bytes.sectionName = read16Bytes();
        bytes.segmentName = read16Bytes();
        bytes.address = read4Bytes(true);
        bytes.size = read4Bytes(true);
        bytes.offset = read4Bytes(true);
        bytes.alignment = read4Bytes(true);
        bytes.rlOffset = read4Bytes(true);
        bytes.rlNum = read4Bytes(true);
        bytes.flags = read4Bytes(true);
        bytes.reserved1OrIndexOfIS = read4Bytes(true);
        bytes.reserved2OrSizeOfStubs = read4Bytes(true);



        return bytes;
    }
}