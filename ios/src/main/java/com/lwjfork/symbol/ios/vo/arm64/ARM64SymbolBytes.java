package com.lwjfork.symbol.ios.vo.arm64;

import com.lwjfork.symbol.ios.vo.arm64.command.ARM64LcBytes;
import com.lwjfork.symbol.ios.vo.arm64.mach_header.ARM64MachHeaderBytes;
import com.lwjfork.symbol.ios.vo.common.base.BaseBytes;
import com.lwjfork.symbol.ios.vo.common.base.BytesCountBytes;
import com.lwjfork.symbol.tools.model.BytesCount;
import lombok.Data;

import java.util.ArrayList;

@Data
public class ARM64SymbolBytes extends BaseBytes {


    public ARM64MachHeaderBytes machHeader;

    public ARM64LcBytes lc;


    public BytesCountBytes stringTable;


    public ArrayList<BytesCountBytes> section = new ArrayList<>();

}
