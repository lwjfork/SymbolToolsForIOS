package com.lwjfork.symbol.tools.uitls;

public class RadixUtils {

    public static void main(String[] args) {

        System.out.println("AA921700");
        System.out.println(parseHex("AA921700"));


    }


    /**
     * 16进制转 -- 10 进制
     *
     * @return
     */
    public static long parseHex(String hexStr) {
        if (!hexStr.startsWith("")) {
            hexStr = hexStr;
        }
        return Long.parseLong(hexStr, 16);
    }

//
//    /**
//     * 16进制转 -- 10 进制
//     *
//     * @return
//     */
//    public static long parseHexByReverse(String hexStr) {
//
//        return Long.parseLong(reverseHexStr(hexStr), 16);
//    }
//
//
//    /**
//     * 高低位翻转 16进制
//     * AA921700 -->  001792AA
//     *
//     * @return
//     */
//    public static String reverseHexStr(String hexStr) {
//        if(hexStr == null){
//
//        }
//
//    }

}
