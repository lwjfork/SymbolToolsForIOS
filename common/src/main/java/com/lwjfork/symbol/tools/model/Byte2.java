package com.lwjfork.symbol.tools.model;

/**
 * 1 个字节的包装类
 */
public final class Byte2 extends AssignCountBytes {

    public Byte2(byte[] bytes) {
        super(bytes);
    }

    public Byte2(byte[] bytes, String offset) {
        this(bytes, true, offset);
    }

    public Byte2(byte[] bytes, boolean isStrictConvertMode, String offset) {
        this(bytes, 2, isStrictConvertMode, offset);
    }

    protected Byte2(byte[] bytes, long bytesCount, boolean isStrictConvertMode, String offset) {
        super(bytes, bytesCount, isStrictConvertMode, offset);
    }




}
