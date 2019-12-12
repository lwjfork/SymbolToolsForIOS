package com.lwjfork.symbol.ios.reader.base;

import java.io.RandomAccessFile;


public abstract class BaseAssignBytesCountReader<T> extends BaseReader<T> {


    /**
     * 最多只能读取多少个字节
     */
    protected long maxBytesCount;

    public long getMaxBytesCount() {
        return maxBytesCount;
    }


    public BaseAssignBytesCountReader(long offset, RandomAccessFile accessFile, long maxBytesCount) {
        super(offset, accessFile);
        this.maxBytesCount = bytesCount;
    }

}
