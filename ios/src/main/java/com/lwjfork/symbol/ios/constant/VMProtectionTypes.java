package com.lwjfork.symbol.ios.constant;

public class VMProtectionTypes {


    public static final long VM_PROT_NONE = 0x00_00_00_00L;

    public static final long VM_PROT_READ = 0x00_00_00_01L;    /* read permission */
    public static final long VM_PROT_WRITE = 0x00_00_00_02L;    /* write permission */
    public static final long VM_PROT_EXECUTE = 0x00_00_00_04L;    /* execute permission */

    /**
     *	The default protection for newly-created virtual memory
     */

    public static final long VM_PROT_DEFAULT = 0x00_00_00_03L;//VM_PROT_READ | VM_PROT_WRITE;

    /**
     *	The maximum privileges possible, for parameter checking.
     */

    public static final long VM_PROT_ALL = 0x00_00_00_07L;//VM_PROT_READ | VM_PROT_WRITE | VM_PROT_EXECUTE;

    /**
     *	An invalid protection value.
     *	Used only by memory_object_lock_request to indicate no change
     *	to page locks.  Using -1 here is a bad idea because it
     *	looks like VM_PROT_ALL and then some.
     */

    public static final long VM_PROT_NO_CHANGE = 0x00_00_00_08L;

    /**
     *      When a caller finds that he cannot obtain write permission on a
     *      mapped entry, the following flag can be used.  The entry will
     *      be made "needs copy" effectively copying the object using COW,
     *      and write permission will be added to the maximum protections
     *      for the associated entry.
     */

    public static final long VM_PROT_COPY = 0x00_00_00_10L;


    /**
     *	Another invalid protection value.
     *	Used only by memory_object_data_request upon an object
     *	which has specified a copy_call copy strategy. It is used
     *	when the kernel wants a page belonging to a copy of the
     *	object, and is only asking the object as a result of
     *	following a shadow chain. This solves the race between pages
     *	being pushed up by the memory manager and the kernel
     *	walking down the shadow chain.
     */

    public static final long VM_PROT_WANTS_COPY = 0x00_00_00_10L;

    /*
     *	The caller wants this memory region treated as if it had a valid
     *	code signature.
     */

    public static final long VM_PROT_TRUSTED = 0x00_00_00_20L;


    /**
     * 	Another invalid protection value.
     *	Indicates that the other protection bits are to be applied as a mask
     *	against the actual protection bits of the map entry.
     */
    public static final long VM_PROT_IS_MASK = 0x00_00_00_40L;

    /**
     * Another invalid protection value to support execute-only protection.
     * VM_PROT_STRIP_READ is a special marker that tells mprotect to not
     * set VM_PROT_READ. We have to do it this way because existing code
     * expects the system to set VM_PROT_READ if VM_PROT_EXECUTE is set.
     * VM_PROT_EXECUTE_ONLY is just a convenience value to indicate that
     * the memory should be executable and explicitly not readable. It will
     * be ignored on platforms that do not support this type of protection.
     */
    public static final long VM_PROT_STRIP_READ = 0x00_00_00_80L;
    public static final long VM_PROT_EXECUTE_ONLY = 0x00_00_00_84L; //VM_PROT_EXECUTE | VM_PROT_STRIP_READ;

}
