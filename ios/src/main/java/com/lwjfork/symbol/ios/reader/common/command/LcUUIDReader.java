package com.lwjfork.symbol.ios.reader.common.command;

import com.lwjfork.symbol.ios.mapper.common.BaseLcMapper;
import com.lwjfork.symbol.ios.model.common.command.LcUuid;
import com.lwjfork.symbol.ios.reader.common.base.BaseAssignBytesCountReader;
import com.lwjfork.symbol.ios.vo.common.command.LcUuidBytes;

import java.io.IOException;
import java.io.RandomAccessFile;

public class LcUUIDReader extends BaseAssignBytesCountReader<LcUuid, LcUuidBytes> {

    public LcUUIDReader(long offset, RandomAccessFile accessFile, long maxByteCount) {
        super(offset, accessFile, maxByteCount);
    }

    @Override
    protected LcUuid convertBytes2Model(LcUuidBytes bytes) {
        return BaseLcMapper.INSTANCE.bytes2Model(bytes);
    }

    @Override
    protected LcUuidBytes readBytes() throws IOException {
        accessFile.seek(offset);
        LcUuidBytes lcUuidBytes = new LcUuidBytes();
        lcUuidBytes.command = read4Bytes(true);
        lcUuidBytes.commandSize = read4Bytes(true);
        lcUuidBytes.uuid = read16Bytes();
        return lcUuidBytes;
    }

    @Override
    protected void writeOffsetAndBytesCount(LcUuidBytes bytes) {
        bytes.useBytesCount = maxBytesCount;
        bytes.offsetOfBytes = getOffsetHexStr();
    }
}
