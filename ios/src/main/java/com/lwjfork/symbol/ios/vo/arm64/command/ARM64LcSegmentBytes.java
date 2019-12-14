package com.lwjfork.symbol.ios.vo.arm64.command;

import com.lwjfork.symbol.ios.vo.common.command.BaseCommandBytes;
import com.lwjfork.symbol.tools.model.Byte16;
import com.lwjfork.symbol.tools.model.Byte4;
import com.lwjfork.symbol.tools.model.Byte8;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ARM64LcSegmentBytes extends BaseCommandBytes {

    public Byte16 segmentName;
    public Byte8 vmAddress;
    public Byte8 vmSize;
    public Byte8 fileOffset;
    public Byte8 fileSize;
    public Byte4 maxVmProtection;
    public Byte4 initialVmProtection;
    public Byte4 sectionsNum;
    public Byte4 flags;


    public List<ARM64LcSectionHeaderBytes> sectionHeaders = new ArrayList<>();
}
