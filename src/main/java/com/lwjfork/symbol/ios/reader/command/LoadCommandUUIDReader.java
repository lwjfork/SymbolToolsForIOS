package com.lwjfork.symbol.ios.reader.command;

import com.lwjfork.symbol.ios.model.command.LoadCommandUUID;
import com.lwjfork.symbol.ios.reader.base.BaseAssignBytesCountReader;

import java.io.IOException;
import java.io.RandomAccessFile;

public class LoadCommandUUIDReader extends BaseAssignBytesCountReader<LoadCommandUUID> {

    public LoadCommandUUIDReader(long offset, RandomAccessFile accessFile, long maxBytesCount) {
        super(offset, accessFile, maxBytesCount);
    }

    @Override
    public LoadCommandUUID read() throws IOException {
        accessFile.seek(offset);
        LoadCommandUUID loadCommandUUID = new LoadCommandUUID();
        loadCommandUUID.command = read4Bytes2Long(true);
        loadCommandUUID.commandSize = read4Bytes2Long(true);
        loadCommandUUID.uuid = read16Bytes2Str();
        loadCommandUUID.useBytesCount = loadCommandUUID.commandSize;
        return loadCommandUUID;
    }
}
