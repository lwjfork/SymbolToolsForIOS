package com.lwjfork.symbol.ios.vo.arm64.mach_header;

import com.lwjfork.symbol.ios.vo.arm.mach_header.ARMMachHeaderBytes;
import com.lwjfork.symbol.tools.model.Byte4;
import lombok.Data;

@Data
public class ARM64MachHeaderBytes extends ARMMachHeaderBytes {


    public Byte4 reserved;


}
