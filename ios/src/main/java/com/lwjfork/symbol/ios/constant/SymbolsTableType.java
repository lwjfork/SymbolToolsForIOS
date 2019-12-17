package com.lwjfork.symbol.ios.constant;

/**
 *
 */

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
 * Symbols with a index into the string table of zero (n_un.n_strx == 0) are
 * defined to have a null, "", name.  Therefore all string indexes to non null
 * names must not have a zero string index.  This is bit historical information
 * that has never been well documented.
 * <p>
 * ref https://github.com/fangshufeng/MachOView/blob/master/MachOView-master/mach-o/nlist.h
 *
 *
 * SymbolsTable  区域中的 type 字段
 */
public class SymbolsTableType {


    /*
     * The n_type field really contains four fields:
     *	unsigned char N_STAB:3,
     *		      N_PEXT:1,
     *		      N_TYPE:3,
     *		      N_EXT:1;
     * which are used via the following masks.
     */
    public static final int N_STAB = 0x00_00_00_E0;/* if any of these bits set, a symbolic debugging entry */
    public static final int N_PEXT = 0x00_00_00_10;/* private external symbol bit */
    public static final int N_TYPE = 0x00_00_00_0E;/* mask for the type bits */
    public static final int N_EXT = 0x00_00_00_01;/* external symbol bit, set for external symbols */

    /*
     * Only symbolic debugging entries have some of the N_STAB bits set and if any
     * of these bits are set then it is a symbolic debugging entry (a stab).  In
     * which case then the values of the n_type field (the entire field) are given
     * in <mach-o/stab.h>
     */

    /*
     * Values for N_TYPE bits of the n_type field.
     */
    public static final int N_UNDF = 0x00_00_00_00;/* undefined, n_sect == NO_SECT */
    public static final int N_ABS = 0x00_00_00_02;/* absolute, n_sect == NO_SECT */
    public static final int N_SECT = 0x00_00_00_0E;/* defined in section number n_sect */
    public static final int N_PBUD = 0x00_00_00_0C;/* prebound undefined (defined in a dylib) */
    public static final int N_INDR = 0x00_00_00_0A;/* indirect */
    /*
     * If the type is N_SECT then the n_sect field contains an ordinal of the
     * section the symbol is defined in.  The sections are numbered from 1 and
     * refer to sections in order they appear in the load commands for the file
     * they are in.  This means the same ordinal may very well refer to different
     * sections in different files.
     *
     * The n_value field for all symbol table entries (including N_STAB's) gets
     * updated by the link editor based on the value of it's n_sect field and where
     * the section n_sect references gets relocated.  If the value of the n_sect
     * field is NO_SECT then it's n_value field is not changed by the link editor.
     */
    public static final int NO_SECT = 0x00_00_00_00;/* symbol is not in any section */
    public static final int MAX_SECT = 0x00_00_00_FF;/* 1 thru 255 inclusive */

}
