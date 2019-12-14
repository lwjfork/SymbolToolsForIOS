package com.lwjfork.symbol.ios.constant;

public class LoadCommandType {


    /**
     * After MacOS X 10.1 when a new load command is added that is required to be
     * understood by the dynamic linker for the image to execute properly the
     * LC_REQ_DYLD bit will be or'ed into the load command constant.  If the dynamic
     * linker sees such a load command it it does not understand will issue a
     * "unknown load command required for execution" error and refuse to use the
     * image.  Other load commands without this bit that are not understood will
     * simply be ignored.
     */
    public static final long LC_REQ_DYLD = 0x80_00_00_00L;

    /**
     * segment of this file to be mapped
     */
    public static final long LC_SEGMENT = 0x00_00_00_01L;
    /**
     * link-edit stab symbol table info
     */
    public static final long LC_SYMTAB = 0x00_00_00_02L;
    /**
     * link-edit gdb symbol table info (obsolete)
     */
    public static final long LC_SYMSEG = 0x00_00_00_03L;
    /**
     * thread
     */
    public static final long LC_THREAD = 0x00_00_00_04L;
    /**
     * unix thread (includes a stack)
     */
    public static final long LC_UNIXTHREAD = 0x00_00_00_05L;
    /**
     * load a specified fixed VM shared library
     */
    public static final long LC_LOADFVMLIB = 0x00_00_00_06L;
    /**
     * fixed VM shared library identification
     */
    public static final long LC_IDFVMLIB = 0x00_00_00_07L;
    /**
     * object identification info (obsolete)
     */
    public static final long LC_IDENT = 0x00_00_00_08L;
    /**
     * fixed VM file inclusion (internal use)
     */
    public static final long LC_FVMFILE = 0x00_00_00_09L;
    /**
     * prepage command (internal use)
     */
    public static final long LC_PREPAGE = 0x00_00_00_0AL;
    /**
     * dynamic link-edit symbol table info
     */
    public static final long LC_DYSYMTAB = 0x00_00_00_0BL;
    /**
     * load a dynamically linked shared library
     */
    public static final long LC_LOAD_DYLIB = 0x00_00_00_0CL;
    /**
     * dynamically linked shared lib ident
     */
    public static final long LC_ID_DYLIB = 0x00_00_00_0DL;
    /**
     * load a dynamic linker
     */
    public static final long LC_LOAD_DYLINKER = 0x00_00_00_0EL;
    /**
     * dynamic linker identification
     */
    public static final long LC_ID_DYLINKER = 0x00_00_00_0FL;
    /** modules prebound for a dynamically */
    /**
     * linked shared library
     */
    public static final long LC_PREBOUND_DYLIB = 0x00_00_00_10L;
    /**
     * image routines
     */
    public static final long LC_ROUTINES = 0x00_00_00_11L;
    /**
     * sub framework
     */
    public static final long LC_SUB_FRAMEWORK = 0x00_00_00_12L;
    /**
     * sub umbrella
     */
    public static final long LC_SUB_UMBRELLA = 0x00_00_00_13L;
    /**
     * sub client
     */
    public static final long LC_SUB_CLIENT = 0x00_00_00_14L;
    /**
     * sub library
     */
    public static final long LC_SUB_LIBRARY = 0x00_00_00_15L;
    /**
     * two-level namespace lookup hints
     */
    public static final long LC_TWOLEVEL_HINTS = 0x00_00_00_16L;
    /**
     * prebind checksum
     */
    public static final long LC_PREBIND_CKSUM = 0x00_00_00_17L;

    /**
     * load a dynamically linked shared library that is allowed to be missing
     * (all symbols are weak imported).
     */
    public static final long LC_LOAD_WEAK_DYLIB = 0x80_00_00_18L;// (0x00_00_00_18L | LC_REQ_DYLD)

    /**
     * 64-bit segment of this file to be
     * mapped
     */
    public static final long LC_SEGMENT_64 = 0x00_00_00_19L;
    /**
     * 64-bit image routines
     */
    public static final long LC_ROUTINES_64 = 0x00_00_00_1AL;
    /**
     * the uuid
     */
    public static final long LC_UUID = 0x00_00_00_1BL;
    /**
     * runpath additions
     */
    public static final long LC_RPATH = 0x80_00_00_1cL; // (0x00_00_00_1CL | LC_REQ_DYLD)
    /**
     * local of code signature
     */
    public static final long LC_CODE_SIGNATURE = 0x00_00_00_1DL;
    /**
     * local of info to split segments
     */
    public static final long LC_SEGMENT_SPLIT_INFO = 0x00_00_00_1EL;

    /**
     * load and re-export dylib
     */
    public static final long LC_REEXPORT_DYLIB = 0x80_00_00_1FL;// (0x00_00_00_1FL | LC_REQ_DYLD)
    /**
     * delay load of dylib until first use
     */
    public static final long LC_LAZY_LOAD_DYLIB = 0x00_00_00_20L;
    /**
     * encrypted segment information
     */
    public static final long LC_ENCRYPTION_INFO = 0x00_00_00_21L;
    /**
     * compressed dyld information
     */
    public static final long LC_DYLD_INFO = 0x00_00_00_22L;

    /**
     * compressed dyld information only
     */
    public static final long LC_DYLD_INFO_ONLY = 0x80_00_00_22L;// (0x00_00_00_22L | LC_REQ_DYLD)

    /**
     * load upward dylib
     */
    public static final long LC_LOAD_UPWARD_DYLIB = 0x80_00_00_23L;// (0x00_00_00_23L | LC_REQ_DYLD)
    /**
     * build for MacOSX min OS version
     */
    public static final long LC_VERSION_MIN_MACOSX = 0x00_00_00_24L;
    /**
     * build for iPhoneOS min OS version
     */
    public static final long LC_VERSION_MIN_IPHONEOS = 0x00_00_00_25L;
    /**
     * compressed table of function start addresses
     */
    public static final long LC_FUNCTION_STARTS = 0x00_00_00_26L;
    /**
     * string for dyld to treat
     * like environment variable
     */
    public static final long LC_DYLD_ENVIRONMENT = 0x00_00_00_27L;

    /**
     * replacement for LC_UNIXTHREAD
     */
    public static final long LC_MAIN = 0x80_00_00_28L; // (0x00_00_00_28L | LC_REQ_DYLD)

    /**
     * table of non-instructions in __text
     */
    public static final long LC_DATA_IN_CODE = 0x00_00_00_29L;
    /**
     * source version used to build binary
     */
    public static final long LC_SOURCE_VERSION = 0x00_00_00_2AL;
    /**
     * Code signing DRs copied from linked dylibs
     */
    public static final long LC_DYLIB_CODE_SIGN_DRS = 0x00_00_00_2BL;
    /**
     * 64-bit encrypted segment information
     */
    public static final long LC_ENCRYPTION_INFO_64 = 0x00_00_00_2CL;
    /**
     * linker options in MH_OBJECT files
     */
    public static final long LC_LINKER_OPTION = 0x00_00_00_2DL;
    /**
     * optimization hints in MH_OBJECT files
     */
    public static final long LC_LINKER_OPTIMIZATION_HINT = 0x00_00_00_2EL;

}
