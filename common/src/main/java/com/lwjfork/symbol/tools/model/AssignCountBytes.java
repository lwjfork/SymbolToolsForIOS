package com.lwjfork.symbol.tools.model;

import com.lwjfork.symbol.tools.uitls.ByteUtil;

import java.math.BigInteger;

public abstract class AssignCountBytes {

    protected byte[] bytes;
    protected long bytesCount;

    protected String hexStrData;

    /**
     * 在字节数组转换为其他类型是，是否是严格模式
     * <p>
     * 当是严格模式时，转换为其他类型是，默认字节数组长度必须小于 待转类型的最大长度
     * <p>
     * 例如 当转换为 long 类型时，我们已知 long 类型为四个字节
     * ** 严格模式下 数组长度必须小于 四个字节
     * ** 非严格模式下 数组长度必须小于等于 四个字节
     */
    protected boolean isStrictConvertMode = true;

    public String offset;

    public AssignCountBytes(byte[] bytes) {
        this(bytes, "unKnow");
    }


    public AssignCountBytes(byte[] bytes, String offset) {
        this(bytes, true, offset);
    }

    public AssignCountBytes(byte[] bytes, boolean isStrictConvertMode, String offset) {
        this(bytes, bytes.length, isStrictConvertMode, offset);
    }

    public AssignCountBytes(byte[] bytes, long bytesCount, String offset) {
        this(bytes, bytesCount, true, offset);
    }

    public AssignCountBytes(byte[] bytes, boolean isStrictConvertMode, long bytesCount) {
        this(bytes, bytesCount, true, "unKnow");
    }

    public long getBytesCount() {
        return bytesCount;
    }

    public AssignCountBytes(byte[] bytes, long bytesCount, boolean isStrictConvertMode, String offset) {
        if (bytes == null) {
            throw new IllegalArgumentException("The byteArray can't be NULL");
        }
        if (bytesCount < 1) {
            throw new IllegalArgumentException("We can't specify a byte array with a length less than 1");
        }
        this.bytes = bytes;
        this.isStrictConvertMode = isStrictConvertMode;
        this.offset = offset;
        this.bytesCount = bytesCount;
        checkBytesCount(bytes, bytesCount);
        hexStrData = ByteUtil.bytes2HexStr(bytes);
    }

    protected void checkBytesCount(byte[] bytes, long bytesCount) {
        int length = bytes.length;
        if (bytesCount != length) {
            throw new IllegalArgumentException(bytesCount + " bytes are required, but the byte array has only " + length + " elements");
        }
    }


    /**
     * 将字节数组转成 16进制的字符串，每一个字节对应两个字符
     *
     * @return
     */
    public String convert2HexStr() {
        return convert2HexStr(false);
    }

    /**
     * 将字节数组转成 16进制的字符串，每一个字节对应两个字符
     *
     * @return
     */
    public String convert2HexStr(boolean isEndian) {
        if (isEndian) {
            bytes = convert2Endian();
        }
        return ByteUtil.bytes2HexStr(bytes);
    }


    /**
     * 大小端转换
     *
     * @return
     */
    public byte[] convert2Endian() {
        return ByteUtil.convertEndian(bytes);
    }


    private void throwException(int maxCount, String suggestMethodName) {
        boolean isThrow = false;
        if (isStrictConvertMode) {
            isThrow = maxCount < bytes.length;
        } else {
            isThrow = maxCount <= bytes.length;
        }
        if (isThrow) {
            throw new UnsupportedOperationException("The length of byte array is " + bytesCount + " you should use the method-[ " + suggestMethodName + " ]");
        }
    }

    /**
     * 把byte转为字符串的bit
     *
     * @return
     */
    public String convert2BitString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte aByte : bytes) {
            stringBuilder.append(ByteUtil.byteToBitString(aByte));
        }
        return stringBuilder.toString();
    }


    /**
     * 将字节数组 转成 int 类型
     *
     * @return
     */
    public int convert2Int() {
        return convert2Int(false);
    }

    /**
     * 将字节数组 转成 int 类型
     *
     * @return
     */
    public int convert2Int(boolean isEndian) {
        throwException(4, "convert2Long");
        if (isEndian) {
            bytes = convert2Endian();
        }
        return ByteUtil.bytes2Int(bytes);
    }


    /**
     * 将字节数组 转成 long 类型
     *
     * @return
     */
    public long convert2Long() {
        return convert2Long(false);
    }

    public long convert2Long(boolean isEndian) {
        throwException(8, "convert2BigInteger");
        if (isEndian) {
            bytes = convert2Endian();
        }
        return ByteUtil.bytes2Long(bytes);
    }

    /**
     * 1--2^500000000
     *
     * @return
     */
    public BigInteger convertBitInteger() {
        return convertBitInteger(false);
    }

    public BigInteger convertBitInteger(boolean isEndian) {
        if (isEndian) {
            bytes = convert2Endian();
        }
        return new BigInteger(1, bytes);
    }

}
