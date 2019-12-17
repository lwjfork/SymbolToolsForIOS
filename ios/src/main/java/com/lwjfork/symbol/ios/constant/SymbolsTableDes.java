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
 * Symbols with a index into the string table of zero (n_un.n_strx == 0) are
 * defined to have a null, "", name.  Therefore all string indexes to non null
 * names must not have a zero string index.  This is bit historical information
 * that has never been well documented.
 * <p>
 * ref https://github.com/fangshufeng/MachOView/blob/master/MachOView-master/mach-o/nlist.h
 * <p>
 * SymbolsTable  区域中的 description 字段
 */

public class SymbolsTableDes {

    /*
     * The bit 0x00_00_00_20 of the n_desc field is used for two non-overlapping purposes
     * and has two different symbolic names, N_NO_DEAD_STRIP and N_DESC_DISCARDED.
     */

    /*
     * The N_NO_DEAD_STRIP bit of the n_desc field only ever appears in a
     * relocatable .o file (MH_OBJECT filetype). And is used to indicate to the
     * static link editor it is never to dead strip the symbol.
     */
    public static final long N_NO_DEAD_STRIP = 0x00_00_00_20; /* symbol is not to be dead stripped */

    /*
     * The N_DESC_DISCARDED bit of the n_desc field never appears in linked image.
     * But is used in very rare cases by the dynamic link editor to mark an in
     * memory symbol as discared and longer used for linking.
     */
    public static final long N_DESC_DISCARDED = 0x00_00_00_20;    /* symbol is discarded */

    /*
     * The N_WEAK_REF bit of the n_desc field indicates to the dynamic linker that
     * the undefined symbol is allowed to be missing and is to have the address of
     * zero when missing.
     */
    public static final long N_WEAK_REF = 0x00_00_00_40; /* symbol is weak referenced */

    /*
     * The N_WEAK_DEF bit of the n_desc field indicates to the static and dynamic
     * linkers that the symbol definition is weak, allowing a non-weak symbol to
     * also be used which causes the weak definition to be discared.  Currently this
     * is only supported for symbols in coalesed sections.
     */
    public static final long N_WEAK_DEF = 0x00_00_00_80; /* coalesed symbol is a weak definition */

    /*
     * The N_REF_TO_WEAK bit of the n_desc field indicates to the dynamic linker
     * that the undefined symbol should be resolved using flat namespace searching.
     */
    public static final long N_REF_TO_WEAK = 0x00_00_00_80; /* reference to a weak symbol */

    /*
     * The N_ARM_THUMB_DEF bit of the n_desc field indicates that the symbol is
     * a defintion of a Thumb function.
     */
    public static final long N_ARM_THUMB_DEF = 0x00_00_00_08; /* symbol is a Thumb function (ARM) */

    /*
     * The N_SYMBOL_RESOLVER bit of the n_desc field indicates that the
     * that the function is actually a resolver function and should
     * be called to get the address of the real function to use.
     * This bit is only available in .o files (MH_OBJECT filetype)
     */
    public static final long N_SYMBOL_RESOLVER = 0x00_00_01_00;

    /*
     * The N_ALT_ENTRY bit of the n_desc field indicates that the
     * symbol is pinned to the previous content.
     */
    public static final long N_ALT_ENTRY = 0x00_00_02_00;


}
