package com.lwjfork.symbol.ios.constant;

import com.lwjfork.symbol.tools.uitls.StrUtils;

public class MagicNumberType {

    public static final long FAT_MAGIC_NUMBER = StrUtils.hexEndianStr2Long("BEBAFECA");
    public static final long MH64_MAGIC_NUMBER = StrUtils.hexEndianStr2Long("FEEDFACF");
    public static final long MH_MAGIC_NUMBER = StrUtils.hexEndianStr2Long("FEEDFACE");



}
