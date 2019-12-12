package com.lwjfork.symbol.tools.uitls;

import java.nio.ByteBuffer;

public class ByteUtil {

    /**
     * 将字节数组转成 16进制的字符串，每一个字节对应两个字符
     *
     * @param bytes
     * @return
     */
    public static String bytes2HexStr(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte aByte : bytes) {
            int byte2Int = byte2Int(aByte);
            String byte2HexStr = Integer.toHexString(byte2Int).toUpperCase();
            int j = byte2HexStr.length();
            for (; j < 2; j++) {
                sb.append("0");
            }
            sb.append(byte2HexStr);
        }
        return sb.toString();
    }

    /**
     * 将字节数组 转成 int 类型
     *
     * @param bytes
     * @return
     */
    public static int bytes2Int(byte[] bytes) {
        int length = bytes.length;
        if (length > 4) {
            throw new IllegalArgumentException("Java 中 int 基本类型四个字节，但是字节数组的长度为 " + length);
        }
        int result = 0;
        for (int i = length - 1; i >= 0; i--) {
            result = result | ((bytes[i] & 0xff) << ((length - i - 1) * 8));
        }
        return result;
    }

    /**
     * 将字节数组 转成 long 类型
     *
     * @param bytes
     * @return
     */
    public static long bytes2Long(byte[] bytes) {
        ByteBuffer buffer = ByteBuffer.allocate(8);
        int length = bytes.length;
        if (length > 8) {
            throw new IllegalArgumentException("Java 中 long 基本类型四个字节，但是字节数组的长度为 " + length);
        }
        byte[] sub = {0, 0, 0, 0};
        buffer.put(sub, 0, sub.length);
        buffer.put(bytes, 0, length);
        buffer.flip();
        return buffer.getLong();
    }


    /**
     * 将单个字节转成 int 类型
     *
     * @param byteValue
     * @return
     */
    public static int byte2Int(byte byteValue) {
        return byteValue & 0xff;
    }


    /**
     * 把byte转为字符串的bit
     *
     * @param b
     * @return
     */
    public static String byteToBitString(byte b) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int j = 7; j >= 0; j--) {
            stringBuilder.append(((b >> j) & 1));
        }
        return stringBuilder.toString();
    }

    /**
     * 大小端转换
     *
     * @return
     */
    public static byte[] convertEndian(byte[] bytes) {
        int length = bytes.length;
        if (length <= 1) {
            return bytes;
        }
        // 判断是否是 2的n次方
        if ((length & (length - 1)) != 0) {
            throw new IllegalArgumentException("字节数组长度必须为2的n次方，不能为 " + length);
        }

        if (bytes.length == 2) {
            byte temp = bytes[0];
            bytes[0] = bytes[1];
            bytes[1] = temp;
            return bytes;
        }
        for (int i = 0; i < length / 2; i++) {
            int swapIndex = length -i - 1;
            byte temp = bytes[i];
            bytes[i] = bytes[swapIndex];
            bytes[swapIndex] = temp;
        }
        return bytes;
    }


    public static byte[] hexStringToBytes(String hexString) {
        if (StrUtils.isEmpty(hexString)) {
            return null;
        }
        hexString = hexString.toUpperCase();
        int length = hexString.length() / 2;
        char[] hexChars = hexString.toCharArray();
        byte[] d = new byte[length];
        for (int i = 0; i < length; i++) {
            int pos = i * 2;
            d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
        }
        return d;
    }

    private static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }


}
