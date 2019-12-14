package com.lwjfork.symbol.ios.constant;

/**
 * Copyright (c) 1999-2010 Apple Inc.  All Rights Reserved.
 *
 * @APPLE_LICENSE_HEADER_START@ This file contains Original Code and/or Modifications of Original Code
 * as defined in and that are subject to the Apple Public Source License
 * Version 2.0 (the 'License'). You may not use this file except in
 * compliance with the License. Please obtain a copy of the License at
 * http://www.opensource.apple.com/apsl/ and read it before using this
 * file.
 * <p>
 * ref https://github.com/gdbinit/MachOView/blob/3431351a76778f156d5a8227290ce5475bc2f528/mach-o/loader.h
 */
public class MachMagicNums {





    /* Constant for the magic field of the mach_header (32-bit architectures) */
    /**
     * the mach magic number
     */
    public static final long MH_MAGIC = 0xCE_FA_ED_FEL;
    /**
     * NXSwapInt(MH_MAGIC)
     */
    public static final long MH_CIGAM =  0xFE_ED_FA_CEL;


    /* Constant for the magic field of the mach_header_64 (64-bit architectures) */
    /**
     * the 64-bit mach magic number
     */
    public static final long MH_MAGIC_64 =  0xCF_FA_ED_FEL;
    /**
     * NXSwapInt(MH_MAGIC_64)
     */
    public static final long MH_CIGAM_64 =0xFE_ED_FA_CFL;

}
