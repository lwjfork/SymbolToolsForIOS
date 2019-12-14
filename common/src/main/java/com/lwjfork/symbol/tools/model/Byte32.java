package com.lwjfork.symbol.tools.model;

/**
 * 32 个 字节的包装类
 */
public final class Byte32 extends AssignCountBytes {


    public Byte32(byte[] bytes) {
        super(bytes);
    }

    public Byte32(byte[] bytes, String offset) {
        this(bytes, true, offset);
    }

    public Byte32(byte[] bytes, boolean isStrictConvertMode, String offset) {
        this(bytes, 32, isStrictConvertMode, offset);
    }

    protected Byte32(byte[] bytes, long bytesCount, boolean isStrictConvertMode, String offset) {
        super(bytes, bytesCount, isStrictConvertMode, offset);
    }

}
