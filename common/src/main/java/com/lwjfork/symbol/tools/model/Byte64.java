package com.lwjfork.symbol.tools.model;

/**
 * 64 个字节的包装类
 */
public final class Byte64 extends AssignCountBytes {



    public Byte64(byte[] bytes) {
        super(bytes);
    }

    public Byte64(byte[] bytes, String offset) {
        this(bytes, true, offset);
    }

    public Byte64(byte[] bytes, boolean isStrictConvertMode, String offset) {
        this(bytes, 64, isStrictConvertMode, offset);
    }

    protected Byte64(byte[] bytes, long bytesCount, boolean isStrictConvertMode, String offset) {
        super(bytes, bytesCount, isStrictConvertMode, offset);
    }

}
