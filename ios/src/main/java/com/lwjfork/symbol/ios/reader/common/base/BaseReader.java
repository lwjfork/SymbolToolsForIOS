package com.lwjfork.symbol.ios.reader.common.base;

import com.lwjfork.symbol.ios.vo.common.base.BaseBytes;
import com.lwjfork.symbol.tools.uitls.ByteUtil;

import java.io.IOException;
import java.io.RandomAccessFile;

public abstract class BaseReader<T, V extends BaseBytes> extends BytesFileReader {


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


    public void seekOffset(long offset) throws IOException {
        accessFile.seek(offset);
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


    /**
     * 应该从那个位置开始读取字节
     *
     * @return
     */
    protected long getStartReadIndex() {
        return offset;
    }


    protected abstract T convertBytes2Model(V bytes);

    protected abstract V readBytes() throws IOException;

    public final V readBytesFinal() throws IOException {
        V readBytes = readBytes();
        writeOffsetAndBytesCount(readBytes);
        return readBytes;
    }


    public final T read() throws IOException {
        V readBytes = readBytesFinal();
        return convertBytes2Model(readBytes);
    }


    protected byte[] readBytes(int count) throws IOException {
        return readBytes(count, false);
    }


    @Override
    protected byte[] readBytes(int count, boolean isEndian) throws IOException {
        byte[] bytes = new byte[count];
        accessFile.read(bytes);
        currentIndex = currentIndex + count;
        bytesCount = bytesCount + count;
        if (isEndian) {
            ByteUtil.convertEndian(bytes);
        }
        return bytes;
    }


    protected abstract void writeOffsetAndBytesCount(V bytes);

    @Override
    public String getReadOffsetHexStr() {
        return Long.toHexString(offset + bytesCount).toUpperCase();
    }

    public String getOffsetHexStr() {
        return Long.toHexString(offset).toUpperCase();
    }


}
