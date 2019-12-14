package com.lwjfork.symbol.tools.model;

/**
 * 未知数量字节的包装类
 */
public final class BytesCount extends AssignCountBytes {


    public BytesCount(byte[] bytes) {
        super(bytes);
    }

    public BytesCount(byte[] bytes, String offset) {
        this(bytes, true, offset);
    }

    public BytesCount(byte[] bytes, boolean isStrictConvertMode, String offset) {
        super(bytes, bytes.length, isStrictConvertMode, offset);
    }


}
