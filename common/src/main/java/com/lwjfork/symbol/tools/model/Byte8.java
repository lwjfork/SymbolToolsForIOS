package com.lwjfork.symbol.tools.model;

/**
 * 8 个字节的包装类
 */
public final class Byte8 extends AssignCountBytes {


    public Byte8(byte[] bytes) {
        super(bytes);
    }

    public Byte8(byte[] bytes, String offset) {
        this(bytes, true, offset);
    }

    public Byte8(byte[] bytes, boolean isStrictConvertMode, String offset) {
        this(bytes, 8, isStrictConvertMode, offset);
    }

    protected Byte8(byte[] bytes, long bytesCount, boolean isStrictConvertMode, String offset) {
        super(bytes, bytesCount, isStrictConvertMode, offset);
    }


}
