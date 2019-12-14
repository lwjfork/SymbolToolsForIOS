package com.lwjfork.symbol.ios.vo.arm64.command;

import com.lwjfork.symbol.ios.vo.common.base.BaseBytes;
import com.lwjfork.symbol.ios.vo.common.command.BaseCommandBytes;
import com.lwjfork.symbol.tools.model.Byte16;
import com.lwjfork.symbol.tools.model.Byte4;
import com.lwjfork.symbol.tools.model.Byte8;
import lombok.Data;

@Data
public class ARM64LcSectionHeaderBytes extends BaseBytes {


    public Byte16 sectionName;
    public Byte16 segmentName;
    public Byte8 address;
    public Byte8 size;
    public Byte4 offset;
    public Byte4 alignment;
    public Byte4 rlOffset;  // Relocations Offset
    public Byte4 rlNum;  // Number of reloactions
    public Byte4 flags;
    public Byte4 reserved1OrIndexOfIS; // reserved1 or Indirect of Sym Index
    public Byte4 reserved2OrSizeOfStubs;  //  reserved2 or Size of Stubs
    public Byte4 reserved3;  //  reserved2 or Size of Stubs


}