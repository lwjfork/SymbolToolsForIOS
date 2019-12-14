package com.lwjfork.symbol.tools.model;

/**
 * 4 个字节的包装类
 */
public final class Byte4 extends AssignCountBytes {


    public Byte4(byte[] bytes) {
        super(bytes);
    }



    public Byte4(byte[] bytes, String offset) {
        this(bytes, true, offset);
    }

    public Byte4(byte[] bytes, boolean isStrictConvertMode, String offset) {
        this(bytes, 4, isStrictConvertMode, offset);
    }

    protected Byte4(byte[] bytes, long bytesCount, boolean isStrictConvertMode, String offset) {
        super(bytes, bytesCount, isStrictConvertMode, offset);
    }


}
