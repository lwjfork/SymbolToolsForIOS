package com.lwjfork.symbol.ios.vo.arm64.command;

import com.lwjfork.symbol.ios.vo.common.command.BaseLcSegmentBytes;
import com.lwjfork.symbol.tools.model.Byte8;
import lombok.Data;

@Data
public class ARM64LcSegmentBytes extends BaseLcSegmentBytes {


    public Byte8 VMAddress;


    public Byte8 VMSize;

    public Byte8 fileOffset;


    public Byte8 fileSize;


}
