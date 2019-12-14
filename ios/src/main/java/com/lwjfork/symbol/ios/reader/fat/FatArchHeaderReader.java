package com.lwjfork.symbol.ios.reader.fat;

import com.lwjfork.symbol.ios.mapper.fat.FatHeaderMapper;
import com.lwjfork.symbol.ios.model.common.header.FatArchHeader;
import com.lwjfork.symbol.ios.reader.common.base.BaseAssignBytesCountReader;
import com.lwjfork.symbol.ios.vo.common.fat.FatArchHeaderBytes;

import java.io.IOException;
import java.io.RandomAccessFile;

public class FatArchHeaderReader extends BaseAssignBytesCountReader<FatArchHeader, FatArchHeaderBytes> {

    FatHeaderMapper mapper = FatHeaderMapper.INSTANCE;


    public FatArchHeaderReader(long offset, RandomAccessFile accessFile) {
        super(offset, accessFile, 20);
    }


    @Override
    protected void writeOffsetAndBytesCount(FatArchHeaderBytes bytes) {
        bytes.offset = bytes.cpuType.offset;
        bytes.useBytesCount = bytesCount;
    }

    @Override
    protected FatArchHeader convertBytes2Model(FatArchHeaderBytes bytes) {

        return mapper.bytes2Model(bytes);
    }

    @Override
    protected FatArchHeaderBytes readBytes() throws IOException {
        accessFile.seek(offset);
        FatArchHeaderBytes archHeaderBytes = new FatArchHeaderBytes();
        archHeaderBytes.cpuType = read4Bytes();
        archHeaderBytes.cpuSubType = read4Bytes();
        archHeaderBytes.symbolsOffset = read4Bytes();
        archHeaderBytes.symbolsSize = read4Bytes();
        archHeaderBytes.symbolsAlign = read4Bytes();
        return archHeaderBytes;
    }
}
