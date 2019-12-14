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
 * The layout of the file depends on the filetype.  For all but the MH_OBJECT
 * file type the segments are padded out and aligned on a segment alignment
 * boundary for efficient demand pageing.  The MH_EXECUTE, MH_FVMLIB, MH_DYLIB,
 * MH_DYLINKER and MH_BUNDLE file types also have the headers included as part
 * of their first segment.
 * <p>
 * The file type MH_OBJECT is a compact format intended as output of the
 * assembler and input (and possibly output) of the link editor (the .o
 * format).  All sections are in one unnamed segment with no segment padding.
 * This format is used as an executable format when the file is so small the
 * segment padding greatly increases its size.
 * <p>
 * The file type MH_PRELOAD is an executable format intended for things that
 * are not executed under the kernel (proms, stand alones, kernels, etc).  The
 * format can be executed under the kernel but may demand paged it and not
 * preload it before execution.
 * <p>
 * A core file is in MH_CORE format and can be any in an arbritray legal
 * Mach-O file.
 * <p>
 * Constants for the filetype field of the mach_header
 */
public class MachFileTypes {


    /**
     * relocatable object file
     */
    public static final long MH_OBJECT = 0x00_00_00_01L;
    /**
     * demand paged executable file
     */
    public static final long MH_EXECUTE = 0x00_00_00_02L;
    /**
     * fixed VM shared library file
     */
    public static final long MH_FVMLIB = 0x00_00_00_03L;
    /**
     * core file
     */
    public static final long MH_CORE = 0x00_00_00_04L;
    /**
     * preloaded executable file
     */
    public static final long MH_PRELOAD = 0x00_00_00_05L;
    /**
     * dynamically bound shared library
     */
    public static final long MH_DYLIB = 0x00_00_00_06L;
    /**
     * dynamic link editor
     */
    public static final long MH_DYLINKER = 0x00_00_00_07L;
    /**
     * dynamically bound bundle file
     */
    public static final long MH_BUNDLE = 0x00_00_00_08L;
    /**
     * shared library stub for static   linking only, no section contents
     */
    public static final long MH_DYLIB_STUB = 0x00_00_00_09L;
    /**
     * companion file with only debug  sections
     */
    public static final long MH_DSYM = 0x00_00_00_0AL;
    /**
     * x86_64 kexts
     */
    public static final long MH_KEXT_BUNDLE = 0x00_00_00_0BL;

    /* Constants for the flags field of the mach_header */
    /**
     * the object file has no undefined
     * references
     */
    public static final long MH_NOUNDEFS = 0x00_00_00_01L;
    /**
     * the object file is the output of an
     * incremental link against a base file
     * and can't be link edited again
     */
    public static final long MH_INCRLINK = 0x00_00_00_02L;
    /**
     * the object file is input for the
     * dynamic linker and can't be staticly
     * link edited again
     */
    public static final long MH_DYLDLINK = 0x00_00_00_04L;
    /**
     * the object file's undefined
     * references are bound by the dynamic
     * linker when loaded.
     */
    public static final long MH_BINDATLOAD = 0x00_00_00_08L;
    /**
     * the file has its dynamic undefined
     * references prebound.
     */
    public static final long MH_PREBOUND = 0x00_00_00_10L;
    /**
     * the file has its read-only and
     * read-write segments split
     */
    public static final long MH_SPLIT_SEGS = 0x00_00_00_20L;
    /**
     * the shared library init routine is
     * to be run lazily via catching memory
     * faults to its writeable segments
     * (obsolete)
     */
    public static final long MH_LAZY_INIT = 0x00_00_00_40L;
    /**
     * the image is using two-level name
     * space bindings
     */
    public static final long MH_TWOLEVEL = 0x00_00_00_80L;
    /**
     * the executable is forcing all images
     * to use flat name space bindings
     */
    public static final long MH_FORCE_FLAT = 0x00_00_01_00L;
    /**
     * this umbrella guarantees no multiple
     * defintions of symbols in its
     * sub-images so the two-level namespace
     * hints can always be used.
     */
    public static final long MH_NOMULTIDEFS = 0x00_00_02_00L;
    /**
     * do not have dyld notify the
     * prebinding agent about this
     * executable
     */
    public static final long MH_NOFIXPREBINDING = 0x00_00_04_00L;
    /**
     * the binary is not prebound but can
     * have its prebinding redone. only used
     * when MH_PREBOUND is not set.
     */
    public static final long MH_PREBINDABLE = 0x00_00_08_00L;
    /**
     * indicates that this binary binds to
     * all two-level namespace modules of
     * its dependent libraries. only used
     * when MH_PREBINDABLE and MH_TWOLEVEL
     * are both set.
     */
    public static final long MH_ALLMODSBOUND = 0x00_00_10_00L;
    /**
     * safe to divide up the sections into
     * sub-sections via symbols for dead
     * code stripping
     */
    public static final long MH_SUBSECTIONS_VIA_SYMBOLS = 0x00_00_20_00L;
    /**
     * the binary has been canonicalized
     * via the unprebind operation
     */
    public static final long MH_CANONICAL = 0x00_00_40_00L;
    /**
     * the final linked image contains
     * external weak symbols
     */
    public static final long MH_WEAK_DEFINES = 0x00_00_80_00L;
    /**
     * the final linked image uses
     * weak symbols
     */
    public static final long MH_BINDS_TO_WEAK = 0x00_01_00_00L;
    /**
     * When this bit is set, all stacks
     * in the task will be given stack
     * execution privilege.  Only used in
     * MH_EXECUTE filetypes.
     */
    public static final long MH_ALLOW_STACK_EXECUTION = 0x00_02_00_00L;
    /**
     * When this bit is set, the binary
     * declares it is safe for use in
     * processes with uid zero
     */
    public static final long MH_ROOT_SAFE = 0x00_04_00_00L;
    /**
     * When this bit is set, the binary
     * declares it is safe for use in
     * processes when issetugid() is true
     */
    public static final long MH_SETUID_SAFE = 0x00_08_00_00L;
    /**
     * When this bit is set on a dylib,
     * the static linker does not need to
     * examine dependent dylibs to see
     * if any are re-exported
     */
    public static final long MH_NO_REEXPORTED_DYLIBS = 0x00_10_00_00L;
    /**
     * When this bit is set, the OS will
     * load the main executable at a
     * random address.  Only used in
     * MH_EXECUTE filetypes.
     */
    public static final long MH_PIE = 0x00_20_00_00L;
    /**
     * Only for use on dylibs.  When
     * linking against a dylib that
     * has this bit set, the static linker
     * will automatically not create a
     * LC_LOAD_DYLIB load command to the
     * dylib if no symbols are being
     * referenced from the dylib.
     */
    public static final long MH_DEAD_STRIPPABLE_DYLIB = 0x00_40_00_00L;
    /**
     * Contains a section of type
     * S_THREAD_LOCAL_VARIABLES
     */

    public static final long MH_HAS_TLV_DESCRIPTORS = 0x00_80_00_00L;
    /**
     * When this bit is set, the OS will
     * run the main executable with
     * a non-executable heap even on
     * platforms (e.g. i386) that don't
     * require it. Only used in MH_EXECUTE
     * filetypes.
     */
    public static final long MH_NO_HEAP_EXECUTION = 0x01_00_00_00L;


}
