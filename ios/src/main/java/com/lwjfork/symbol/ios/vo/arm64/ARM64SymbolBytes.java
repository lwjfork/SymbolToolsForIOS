package com.lwjfork.symbol.ios.vo.arm64;

import com.lwjfork.symbol.ios.vo.arm64.command.ARM64LcBytes;
import com.lwjfork.symbol.ios.vo.arm64.mach_header.ARM64MachHeaderBytes;
import com.lwjfork.symbol.ios.vo.common.base.BaseSymbolBytes;
import lombok.Data;

@Data
public class ARM64SymbolBytes extends BaseSymbolBytes {


    public ARM64MachHeaderBytes machHeader;

    public ARM64LcBytes lc;




}
