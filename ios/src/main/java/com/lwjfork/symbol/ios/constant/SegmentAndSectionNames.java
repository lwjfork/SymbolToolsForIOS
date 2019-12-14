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
 * <p>
 * ref https://github.com/gdbinit/MachOView/blob/3431351a76778f156d5a8227290ce5475bc2f528/mach-o/loader.h
 * <p>
 * the name of a section or segment
 */
public class SegmentAndSectionNames {

    /**
     * the pagezero segment which has no
     * protections and catches NULL
     * references for MH_EXECUTE files
     */
    public static final String SEG_PAGEZERO = "__PAGEZERO";

    /**
     * the tradition UNIX text segment
     */
    public static final String SEG_TEXT = "__TEXT";
    /**
     * the real text part of the text
     * section no headers, and no padding
     */
    public static final String SECT_TEXT = "__text";
    /**
     * the fvmlib initialization section
     */
    public static final String SECT_FVMLIB_INIT0 = "__fvmlib_init0";

    /**
     * the section following the fvmlib initialization  section
     */
    public static final String SECT_FVMLIB_INIT1 = "__fvmlib_init1";
    /**
     * the tradition UNIX data segment
     */
    public static final String SEG_DATA = "__DATA";
    /**
     * the real initialized data section  no padding, no bss overlap
     */
    public static final String SECT_DATA = "__data";
    /**
     * the real uninitialized data section no padding
     */
    public static final String SECT_BSS = "__bss";
    /**
     * the section common symbols are allocated in by the link editor
     */
    public static final String SECT_COMMON = "__common";
    /**
     * objective-C runtime segment
     */
    public static final String SEG_OBJC = "__OBJC";
    /**
     * symbol table
     */
    public static final String SECT_OBJC_SYMBOLS = "__symbol_table";
    /**
     * module information
     */
    public static final String SECT_OBJC_MODULES = "__module_info";
    /**
     * string table
     */
    public static final String SECT_OBJC_STRINGS = "__selector_strs";
    /**
     * string table
     */
    public static final String SECT_OBJC_REFS = "__selector_refs";
    /**
     * the icon segment
     */
    public static final String SEG_ICON = "__ICON";
    /**
     * the icon headers
     */
    public static final String SECT_ICON_HEADER = "__header";
    /**
     * the icons in tiff format
     */
    public static final String SECT_ICON_TIFF = "__tiff";


    /**
     * the segment containing all structs
     * created and maintained by the link editor.
     * Created with -seglinkedit option to ld(1) for MH_EXECUTE and FVMLIB file types only
     */
    public static final String SEG_LINKEDIT = "__LINKEDIT";

    /**
     * the unix stack segment
     */
    public static final String SEG_UNIXSTACK = "__UNIXSTACK";

    /**
     * the segment for the self (dyld)
     * modifing code stubs that has read,
     * write and execute permissions
     */
    public static final String SEG_IMPORT = "__IMPORT";


}
