package com.lwjfork.symbol.ios.vo.common.command;

import com.lwjfork.symbol.tools.model.Byte16;
import com.lwjfork.symbol.tools.model.Byte4;
import lombok.Data;

@Data
public class BaseLcSegmentBytes extends BaseCommandBytes {


    public Byte16 segmentName;


    public Byte4 maxVMProtection;

    public Byte4 initialVMProtection;

    public Byte4 sectionsNum;

    public Byte4 flags;


}
