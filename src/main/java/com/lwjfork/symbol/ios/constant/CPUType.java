package com.lwjfork.symbol.ios.constant;

import com.lwjfork.symbol.tools.uitls.StrUtils;

public class CPUType {

    public static final long ARM = StrUtils.hexEndianStr2Long("0000000C");
    public static final long ARM64 = StrUtils.hexEndianStr2Long("0100000C");


}
