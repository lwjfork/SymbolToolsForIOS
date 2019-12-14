package com.lwjfork.symbol.ios.reader.arm64.header;

import com.lwjfork.symbol.ios.mapper.arm64.ARM64MachHeaderMapper;
import com.lwjfork.symbol.ios.model.arm64.mach_header.ARM64MachHeader;
import com.lwjfork.symbol.ios.reader.common.base.BaseMachHeaderReader;
import com.lwjfork.symbol.ios.vo.arm64.mach_header.ARM64MachHeaderBytes;
import com.lwjfork.symbol.tools.model.Byte4;

import java.io.IOException;
import java.io.RandomAccessFile;

public class ARM64MachHeaderReader extends BaseMachHeaderReader<ARM64MachHeader, ARM64MachHeaderBytes> {

    ARM64MachHeaderMapper lcMapper = ARM64MachHeaderMapper.INSTANCE;


    public ARM64MachHeaderReader(long offset, RandomAccessFile accessFile) {
        super(offset, accessFile, 32);
    }


    @Override
    protected void writeOffsetAndBytesCount(ARM64MachHeaderBytes bytes) {
        super.writeOffsetAndBytesCount(bytes);
    }

    @Override
    protected ARM64MachHeader convertBytes2Model(ARM64MachHeaderBytes bytes) {
        return lcMapper.bytes2Model(bytes);
    }

    @Override
    protected ARM64MachHeaderBytes readBytes() throws IOException {
        accessFile.seek(offset);
        ARM64MachHeaderBytes machHeaderBytes = new ARM64MachHeaderBytes();
        readCommon(machHeaderBytes);
        machHeaderBytes.reserved = read4Bytes(true);
        writeOffsetAndBytesCount(machHeaderBytes);
        return machHeaderBytes;
    }

}
