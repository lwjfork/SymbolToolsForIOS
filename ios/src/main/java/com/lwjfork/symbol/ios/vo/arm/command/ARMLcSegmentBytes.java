package com.lwjfork.symbol.ios.vo.arm.command;

import com.lwjfork.symbol.ios.vo.common.command.BaseLcSegmentBytes;
import com.lwjfork.symbol.tools.model.Byte4;
import lombok.Data;

@Data
public class ARMLcSegmentBytes extends BaseLcSegmentBytes {


    public Byte4 VMAddress;


    public Byte4 VMSize;

    public Byte4 fileOffset;


    public Byte4 fileSize;


}
