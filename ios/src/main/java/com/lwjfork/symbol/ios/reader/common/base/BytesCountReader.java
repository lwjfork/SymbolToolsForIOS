package com.lwjfork.symbol.ios.reader.common.base;

import com.lwjfork.symbol.ios.mapper.common.BytesCountMapper;
import com.lwjfork.symbol.ios.model.common.base.BytesCountStr;
import com.lwjfork.symbol.ios.vo.common.base.BytesCountBytes;

import java.io.IOException;
import java.io.RandomAccessFile;

public class BytesCountReader extends BaseAssignBytesCountReader<BytesCountStr, BytesCountBytes>{


    public BytesCountReader(long offset, RandomAccessFile accessFile, long maxBytesCount) {
        super(offset, accessFile, maxBytesCount);
    }

    @Override
    protected BytesCountStr convertBytes2Model(BytesCountBytes bytes) {
        return BytesCountMapper.INSTANCE.convertStr(bytes);
    }

    @Override
    protected BytesCountBytes readBytes() throws IOException {
        return null;
    }

    @Override
    protected void writeOffsetAndBytesCount(BytesCountBytes bytes) {

    }
}
