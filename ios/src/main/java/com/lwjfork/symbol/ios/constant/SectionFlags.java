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
 * <p>
 * Constants for the type of a section
 */


public class SectionFlags {


    /*
     * The flags field of a section structure is separated into two parts a section
     * type and section attributes.  The section types are mutually exclusive (it
     * can only have one type) but the section attributes are not (it may have more
     * than one attribute).
     */
    /**
     * 256 section types
     */
    public static final long SECTION_TYPE = 0x00_00_00_FFL;
    /**
     * 24 section attributes
     */
    public static final long SECTION_ATTRIBUTES = 0xFF_FF_FF_00L;


    /**
     * regular section
     */
    public static final long S_REGULAR = 0x00_00_00_00L;
    /**
     * zero fill on demand section
     */
    public static final long S_ZEROFILL = 0x00_00_00_01L;
    /**
     * section with only literal C strings
     */
    public static final long S_CSTRING_LITERALS = 0x00_00_00_02L;
    /**
     * section with only 4 byte literals
     */
    public static final long S_4BYTE_LITERALS = 0x00_00_00_03L;
    /**
     * section with only 8 byte literals
     */
    public static final long S_8BYTE_LITERALS = 0x00_00_00_04L;
    /**
     * section with only pointers to
     */
    public static final long S_LITERAL_POINTERS = 0x00_00_00_05L;

    /**  literals */
    /**
     * For the two types of symbol pointers sections and the symbol stubs section
     * they have indirect symbol table entries.  For each of the entries in the
     * section the indirect symbol table entries, in corresponding order in the
     * indirect symbol table, start at the index stored in the reserved1 field
     * of the section structure.  Since the indirect symbol table entries
     * correspond to the entries in the section the number of indirect symbol table
     * entries is inferred from the size of the section divided by the size of the
     * entries in the section.  For symbol pointers sections the size of the entries
     * in the section is 4 bytes and for symbol stubs sections the byte size of the
     * stubs is stored in the reserved2 field of the section structure.
     */

    /**
     * section with only non-lazy
     * symbol pointers
     */
    public static final long S_NON_LAZY_SYMBOL_POINTERS = 0x00_00_00_06L;
    /**
     * section with only lazy symbol
     * pointers
     */
    public static final long S_LAZY_SYMBOL_POINTERS = 0x00_00_00_07L;
    /**
     * section with only symbol
     * stubs, byte size of stub in
     * the reserved2 field
     */
    public static final long S_SYMBOL_STUBS = 0x00_00_00_08L;
    /**
     * section with only function
     * pointers for initialization
     */
    public static final long S_MOD_INIT_FUNC_POINTERS = 0x00_00_00_09L;
    /**
     * section with only function
     * pointers for termination
     */
    public static final long S_MOD_TERM_FUNC_POINTERS = 0x00_00_00_0AL;
    /**
     * section contains symbols that
     * are to be coalesced
     */
    public static final long S_COALESCED = 0x00_00_00_0BL;
    /**
     * zero fill on demand section
     * (that can be larger than 4
     * gigabytes)
     */
    public static final long S_GB_ZEROFILL = 0x00_00_00_0CL;
    /**
     * section with only pairs of
     * function pointers for
     * interposing
     */
    public static final long S_INTERPOSING = 0x00_00_00_0DL;
    /**
     * section with only 16 byte
     * literals
     */
    public static final long S_16BYTE_LITERALS = 0x00_00_00_0EL;
    /**
     * section contains
     * DTrace Object Format
     */
    public static final long S_DTRACE_DOF = 0x00_00_00_0FL;
    /**
     * section with only lazy
     * symbol pointers to lazy
     * loaded dylibs
     */
    public static final long S_LAZY_DYLIB_SYMBOL_POINTERS = 0x00_00_00_10L;
    /**
     * Section types to support thread local variables
     */

    /**
     * template of initial
     * values for TLVs
     */
    public static final long S_THREAD_LOCAL_REGULAR = 0x00_00_00_11L;
    /**
     * template of initial
     * values for TLVs
     */
    public static final long S_THREAD_LOCAL_ZEROFILL = 0x00_00_00_12L;
    /**
     * TLV descriptors
     */
    public static final long S_THREAD_LOCAL_VARIABLES = 0x00_00_00_13L;
    /**
     * pointers to TLV
     * descriptors
     */
    public static final long S_THREAD_LOCAL_VARIABLE_POINTERS = 0x00_00_00_14L;
    /**
     * functions to call
     * to initialize TLV
     * values
     */
    public static final long S_THREAD_LOCAL_INIT_FUNCTION_POINTERS = 0x00_00_00_15L;

    /**
     * Constants for the section attributes part of the flags field of a section
     * structure.
     */

    /**
     * User setable attributes
     */
    public static final long SECTION_ATTRIBUTES_USR = 0xFF_00_00_00L;
    /**
     * section contains only true
     * machine instructions
     */
    public static final long S_ATTR_PURE_INSTRUCTIONS = 0x80_00_00_00L;
    /**
     * section contains coalesced
     * symbols that are not to be
     * in a ranlib table of
     * contents
     */
    public static final long S_ATTR_NO_TOC = 0x40_00_00_00L;
    /**
     * ok to strip static symbols
     * in this section in files
     * with the MH_DYLDLINK flag
     */
    public static final long S_ATTR_STRIP_STATIC_SYMS = 0x20_00_00_00L;
    /**
     * no dead stripping
     */
    public static final long S_ATTR_NO_DEAD_STRIP = 0x10_00_00_00L;
    /**
     * blocks are live if they
     * reference live blocks
     */
    public static final long S_ATTR_LIVE_SUPPORT = 0x08_00_00_00L;
    /**
     * Used with i386 code stubs
     * written on by dyld
     */
    public static final long S_ATTR_SELF_MODIFYING_CODE = 0x04_00_00_00L;
    /**
     * If a segment contains any sections marked with S_ATTR_DEBUG then all
     * sections in that segment must have this attribute.  No section other than
     * a section marked with this attribute may reference the contents of this
     * section.  A section with this attribute may contain no symbols and must have
     * a section type S_REGULAR.  The static linker will not copy section contents
     * from sections with this attribute into its output file.  These sections
     * generally contain DWARF debugging info.
     */

    /**
     * a debug section
     */
    public static final long S_ATTR_DEBUG = 0x02_00_00_00L;
    /**
     * system setable attributes
     */
    public static final long SECTION_ATTRIBUTES_SYS = 0x00_FF_FF_00L;
    /**
     * section contains some
     * machine instructions
     */
    public static final long S_ATTR_SOME_INSTRUCTIONS = 0x00_00_04_00L;
    /**
     * section has external
     * relocation entries
     */
    public static final long S_ATTR_EXT_RELOC = 0x00_00_02_00L;
    /**
     * section has local
     * relocation entries
     */
    public static final long S_ATTR_LOC_RELOC = 0x00_00_01_00L;


}
