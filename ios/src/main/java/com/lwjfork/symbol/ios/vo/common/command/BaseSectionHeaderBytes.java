package com.lwjfork.symbol.ios.vo.common.command;

import com.lwjfork.symbol.ios.vo.common.base.BaseBytes;
import com.lwjfork.symbol.tools.model.Byte16;
import com.lwjfork.symbol.tools.model.Byte4;
import lombok.Data;

@Data
public class BaseSectionHeaderBytes extends BaseBytes {

    public Byte16 sectionName;
    public Byte16 segmentName;
    public Byte4 offset;
    public Byte4 alignment;
    public Byte4 rlOffset;  // Relocations Offset
    public Byte4 rlNum;  // Number of reloactions
    public Byte4 flags;


}
