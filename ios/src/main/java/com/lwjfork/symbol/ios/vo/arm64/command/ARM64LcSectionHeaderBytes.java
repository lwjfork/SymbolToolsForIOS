package com.lwjfork.symbol.ios.vo.arm64.command;

import com.lwjfork.symbol.ios.vo.common.command.BaseSectionHeaderBytes;
import com.lwjfork.symbol.tools.model.Byte4;
import com.lwjfork.symbol.tools.model.Byte8;
import lombok.Data;

@Data
public class ARM64LcSectionHeaderBytes extends BaseSectionHeaderBytes {



    public Byte8 address;
    public Byte8 size;

    public Byte4 reserved1OrIndexOfIS; // reserved1 or Indirect of Sym Index
    public Byte4 reserved2OrSizeOfStubs;  //  reserved2 or Size of Stubs
    public Byte4 reserved3;  //  reserved2 or Size of Stubs


}
