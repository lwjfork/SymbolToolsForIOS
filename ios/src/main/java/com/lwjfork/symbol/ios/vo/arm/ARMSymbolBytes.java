package com.lwjfork.symbol.ios.vo.arm;

import com.lwjfork.symbol.ios.vo.arm.command.ARMLcBytes;
import com.lwjfork.symbol.ios.vo.arm.mach_header.ARMMachHeaderBytes;
import com.lwjfork.symbol.ios.vo.common.base.BaseBytes;
import com.lwjfork.symbol.ios.vo.common.base.BytesCountBytes;
import com.lwjfork.symbol.tools.model.BytesCount;

import java.util.ArrayList;

public class ARMSymbolBytes extends BaseBytes {

    public ARMMachHeaderBytes machHeader;

    public ARMLcBytes lc;

    public BytesCountBytes stringTable;


    public ArrayList<BytesCountBytes> section = new ArrayList<>();

}
