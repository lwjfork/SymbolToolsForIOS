package com.lwjfork.symbol.ios.reader.arm.header;

import com.lwjfork.symbol.ios.mapper.arm.ARMMachHeaderMapper;
import com.lwjfork.symbol.ios.model.arm.mach_header.ARMMachHeader;
import com.lwjfork.symbol.ios.reader.common.base.BaseMachHeaderReader;
import com.lwjfork.symbol.ios.vo.arm.mach_header.ARMMachHeaderBytes;
import com.lwjfork.symbol.tools.model.Byte4;

import java.io.IOException;
import java.io.RandomAccessFile;

public class ARMMachHeaderReader extends BaseMachHeaderReader<ARMMachHeader, ARMMachHeaderBytes> {


    protected ARMMachHeaderMapper mapper = ARMMachHeaderMapper.INSTANCE;

    public ARMMachHeaderReader(long offset, RandomAccessFile accessFile) {
        super(offset, accessFile, 28);
    }


    @Override
    protected void writeOffsetAndBytesCount(ARMMachHeaderBytes bytes) {
        super.writeOffsetAndBytesCount(bytes);
    }

    @Override
    protected ARMMachHeader convertBytes2Model(ARMMachHeaderBytes bytes) {
        return mapper.bytes2Model(bytes);
    }

    @Override
    protected ARMMachHeaderBytes readBytes() throws IOException {
        accessFile.seek(offset);
        ARMMachHeaderBytes machHeaderBytes = new ARMMachHeaderBytes();
        readCommon(machHeaderBytes);
        return machHeaderBytes;
    }

}
