package com.lwjfork.symbol.ios.reader.common.base;

import com.lwjfork.symbol.tools.model.*;

import java.io.IOException;

public abstract class BytesFileReader {


    public abstract String getReadOffsetHexStr();

    protected abstract byte[] readBytes(int count, boolean isEndian) throws IOException;

    public Byte1 readByte() throws IOException {
        return readByte(false);
    }

    public Byte2 read2Bytes() throws IOException {
        return read2Bytes(false);
    }

    public Byte4 read4Bytes() throws IOException {

        return read4Bytes(false);
    }

    public Byte8 read8Bytes() throws IOException {

        return read8Bytes(false);
    }

    public Byte16 read16Bytes() throws IOException {
        return read16Bytes(false);
    }

    public Byte32 read32Bytes() throws IOException {
        return read32Bytes(false);
    }

    public Byte64 read64Bytes() throws IOException {
        return read64Bytes(false);
    }

    public BytesCount readAssignCountBytes(int bytesCount) throws IOException {
        return readAssignCountBytes(bytesCount, false);
    }


    public Byte1 readByte(boolean isEndian) throws IOException {
        String offset = getReadOffsetHexStr();
        return new Byte1(readBytes(1, isEndian), offset);
    }

    public Byte2 read2Bytes(boolean isEndian) throws IOException {
        String offset = getReadOffsetHexStr();
        return new Byte2(readBytes(2, isEndian), offset);
    }

    public Byte4 read4Bytes(boolean isEndian) throws IOException {
        String offset = getReadOffsetHexStr();
        return new Byte4(readBytes(4, isEndian), offset);
    }

    public Byte8 read8Bytes(boolean isEndian) throws IOException {
        String offset = getReadOffsetHexStr();
        return new Byte8(readBytes(8, isEndian), offset);
    }

    public Byte16 read16Bytes(boolean isEndian) throws IOException {
        String offset = getReadOffsetHexStr();
        return new Byte16(readBytes(16, isEndian), offset);
    }

    public Byte32 read32Bytes(boolean isEndian) throws IOException {
        String offset = getReadOffsetHexStr();
        return new Byte32(readBytes(32, isEndian), offset);
    }

    public Byte64 read64Bytes(boolean isEndian) throws IOException {
        String offset = getReadOffsetHexStr();
        return new Byte64(readBytes(64, isEndian), offset);
    }


    private BytesCount readAssignCountBytes(int bytesCount, boolean isEndian) throws IOException {
        String offset = getReadOffsetHexStr();
        return new BytesCount(readBytes(bytesCount, isEndian), offset);
    }


}
