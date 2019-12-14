package com.lwjfork.symbol.ios.vo.arm;

import com.lwjfork.symbol.ios.vo.arm.command.ARMLcBytes;
import com.lwjfork.symbol.ios.vo.arm.mach_header.ARMMachHeaderBytes;
import com.lwjfork.symbol.ios.vo.common.base.BaseBytes;

public class ARMSymbolBytes extends BaseBytes {

    public ARMMachHeaderBytes machHeader;

    public ARMLcBytes lc;

}
