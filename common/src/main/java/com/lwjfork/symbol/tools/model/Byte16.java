package com.lwjfork.symbol.tools.model;

/**
 * 16 个字节的包装类
 */
public final class Byte16 extends AssignCountBytes {


    public Byte16(byte[] bytes) {
        super(bytes);
    }

    public Byte16(byte[] bytes, String offset) {
        this(bytes, true, offset);
    }

    public Byte16(byte[] bytes, boolean isStrictConvertMode, String offset) {
        this(bytes, 16, isStrictConvertMode, offset);
    }

    protected Byte16(byte[] bytes, long bytesCount, boolean isStrictConvertMode, String offset) {
        super(bytes, bytesCount, isStrictConvertMode, offset);
    }

}
