package com.lwjfork.symbol.ios.vo.arm.command;

import com.lwjfork.symbol.ios.vo.common.command.BaseSectionHeaderBytes;
import com.lwjfork.symbol.tools.model.Byte4;
import lombok.Data;

@Data
public class ARMLcSectionHeaderBytes extends BaseSectionHeaderBytes {


    public Byte4 address;
    public Byte4 size;
    public Byte4 reserved1OrIndexOfIS; // reserved1 or Indirect of Sym Index
    public Byte4 reserved2OrSizeOfStubs;  //  reserved2 or Size of Stubs


}
