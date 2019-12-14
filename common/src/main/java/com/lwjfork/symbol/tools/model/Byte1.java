package com.lwjfork.symbol.tools.model;

/**
 * 1 个字节的包装类
 */
public final  class Byte1 extends AssignCountBytes {

    public Byte1(byte[] bytes) {
        super(bytes);
    }

    public Byte1(byte[] bytes, String offset) {
        this(bytes, true, offset);
    }

    public Byte1(byte[] bytes, boolean isStrictConvertMode, String offset) {
        this(bytes, 1, isStrictConvertMode, offset);
    }

    protected Byte1(byte[] bytes, long bytesCount, boolean isStrictConvertMode, String offset) {
        super(bytes, bytesCount, isStrictConvertMode, offset);
    }

}
