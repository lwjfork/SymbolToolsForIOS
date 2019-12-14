package com.lwjfork.symbol.ios.constant;

public class FatMagicNum {
    /* Constant for the magic field of the Fat_header (32-bit architectures) */
    /**
     * the fat magic number
     */
    public static final long FAT_MAGIC = 0xCA_FE_BA_BEL;
    /**
     * NXSwapInt(FAT_MAGIC)
     */
    public static final long FAT_CIGAM = 0xBE_BA_FE_CAL;



}
