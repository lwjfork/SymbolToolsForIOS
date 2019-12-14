package com.lwjfork.symbol.ios.reader.common.command;

import com.lwjfork.symbol.ios.reader.common.base.BytesCountReader;

import java.io.RandomAccessFile;

public class StringTableReader extends BytesCountReader {
    public StringTableReader(long offset, RandomAccessFile accessFile, long maxBytesCount) {
        super(offset, accessFile, maxBytesCount);
    }
}
