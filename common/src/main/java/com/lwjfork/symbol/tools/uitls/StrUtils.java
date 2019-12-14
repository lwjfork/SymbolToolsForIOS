package com.lwjfork.symbol.tools.uitls;

public class StrUtils {


    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }


    public static long hexEndianStr2Long(String hexStr) {
        return Long.parseLong(convertEndian(hexStr), 16);
    }

    public static long hexStr2Long(String hexStr) {
        return Long.parseLong(hexStr, 16);
    }


    public static String asciiStrToString(String source) {
        return asciiStrToString(source, false);
    }

    public static String asciiStrToString(String source, boolean isTrim) {
        int length = source.length();
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = source.toCharArray();
        for (int i = 0; i < length; i += 2) {
            stringBuilder.append((char) Integer.parseUnsignedInt(new String(chars, i, 2), 16));
        }
        if (isTrim) {
            return stringBuilder.toString().trim();
        } else {
            return stringBuilder.toString();
        }
    }


    public static String asciiBytesToString(byte[] source, boolean isTrim) {

        String hexStr = ByteUtil.bytes2HexStr(source);

        return asciiStrToString(hexStr, isTrim);
    }


    /**
     * 大小端转换
     *
     * @return
     */
    public static String convertEndian(String array) {
        char[] bytes = array.toCharArray();
        int length = bytes.length;
        if (length <= 1) {
            return array;
        }
        // 判断是否是 2的n次方
        if ((length & (length - 1)) != 0) {
            throw new IllegalArgumentException("字节数组长度必须为2的n次方，不能为 " + length);
        }

        if (bytes.length == 2) {
            char temp = bytes[0];
            bytes[0] = bytes[1];
            bytes[1] = temp;
            return new String(bytes);
        }
        for (int i = 0; i < length / 2; i++) {
            int swapIndex = length - (i + (1 - i % 2) * 2);
            char temp = bytes[i];
            bytes[i] = bytes[swapIndex];
            bytes[swapIndex] = temp;
        }
        return new String(bytes);
    }


    public static String asciiToChar(String value) {
        StringBuffer sbu = new StringBuffer();
        String[] chars = value.split(",");
        for (int i = 0; i < chars.length; i++) {
            sbu.append((char) Integer.parseInt(chars[i]));
        }
        return sbu.toString();
    }


}
