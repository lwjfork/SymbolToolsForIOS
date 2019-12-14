package com.lwjfork.symbol.ios.reader.common.base;

import com.lwjfork.symbol.ios.vo.common.base.BaseBytes;

import java.io.RandomAccessFile;


public abstract class BaseAssignBytesCountReader<T, V extends BaseBytes> extends BaseReader<T, V> {


    /**
     * 最多只能读取多少个字节
     */
    protected long maxBytesCount;

    public long getMaxBytesCount() {
        return maxBytesCount;
    }


    public BaseAssignBytesCountReader(long offset, RandomAccessFile accessFile, long maxBytesCount) {
        super(offset, accessFile);
        this.maxBytesCount = maxBytesCount;
    }


}
