package com.lwjfork.symbol.ios.vo.common.fat;

import com.lwjfork.symbol.ios.vo.common.base.BaseBytes;
import com.lwjfork.symbol.tools.model.Byte4;
import lombok.Data;

@Data
public class FatArchHeaderBytes extends BaseBytes {

    public Byte4 cpuType;
    public Byte4 cpuSubType;
    public Byte4 symbolsOffset;
    public Byte4 symbolsSize;
    public Byte4 symbolsAlign;



}
