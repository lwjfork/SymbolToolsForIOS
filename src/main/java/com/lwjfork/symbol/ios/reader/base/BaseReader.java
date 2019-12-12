package com.lwjfork.symbol.ios.reader.base;

import com.lwjfork.symbol.tools.uitls.ByteUtil;

import java.io.IOException;
import java.io.RandomAccessFile;

public abstract class BaseReader<T> {


    /**
     * 相对 可读块 开始索引的 偏移字节数
     */
    protected long offset;


    protected long currentIndex;


    /**
     * 读取了多少个字节
     */
    protected long bytesCount = 0;


    protected RandomAccessFile accessFile;

    public BaseReader(long offset, RandomAccessFile accessFile) {
        this.offset = offset;
        this.accessFile = accessFile;
        currentIndex = getStartReadIndex();
    }

    public long getOffset() {
        return offset;
    }

    public long getCurrentIndex() {
        return currentIndex;
    }


    public long getBytesCount() {
        return bytesCount;
    }


    public RandomAccessFile getAccessFile() {
        return accessFile;
    }

    public abstract T read() throws IOException;

    /**
     * 应该从那个位置开始读取字节
     *
     * @return
     */
    public long getStartReadIndex() {
        return offset;
    }


    public byte[] readBytes(int count) throws IOException {
        byte[] bytes = new byte[count];
        accessFile.read(bytes);
        currentIndex = currentIndex + count;
        bytesCount = bytesCount + count;
        return bytes;
    }


    public byte readByte() throws IOException {
        return readBytes(1)[0];
    }


    public byte[] read2Bytes() throws IOException {
        return readBytes(2);
    }

    public byte[] read4Bytes() throws IOException {
        return readBytes(4);
    }


    public long read4Bytes2Long(boolean isEndian) throws IOException {
        if (isEndian) {
            return ByteUtil.bytes2Long(ByteUtil.convertEndian(readBytes(4)));
        } else {
            return ByteUtil.bytes2Long(readBytes(4));
        }
    }

    public long read4Bytes2Long() throws IOException {
        return read4Bytes2Long(false);
    }

    public String read16Bytes2Str() throws IOException {
        byte[] bytes = read16Bytes();
        return ByteUtil.bytes2HexStr(bytes);
    }


    public byte[] read8Bytes() throws IOException {
        return readBytes(8);
    }

    public byte[] read16Bytes() throws IOException {
        return readBytes(16);
    }
}
