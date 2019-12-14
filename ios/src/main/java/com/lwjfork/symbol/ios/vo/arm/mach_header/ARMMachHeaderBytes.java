package com.lwjfork.symbol.ios.vo.arm.mach_header;

import com.lwjfork.symbol.ios.vo.common.base.BaseBytes;
import com.lwjfork.symbol.tools.model.Byte4;
import lombok.Data;

@Data
public class ARMMachHeaderBytes extends BaseBytes {

    public Byte4 magicNum;
    public Byte4 cpuType;
    public Byte4 cpuSubType;
    public Byte4 fileType;
    public Byte4 commandsNum;
    public Byte4 commandSize;
    public Byte4 flags;




}
