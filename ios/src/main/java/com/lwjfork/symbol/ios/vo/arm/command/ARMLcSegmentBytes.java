package com.lwjfork.symbol.ios.vo.arm.command;

import com.lwjfork.symbol.ios.vo.common.command.BaseCommandBytes;
import com.lwjfork.symbol.tools.model.Byte16;
import com.lwjfork.symbol.tools.model.Byte4;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ARMLcSegmentBytes extends BaseCommandBytes {


    public Byte16 segmentName;
    public Byte4 vmAddress;
    public Byte4 vmSize;
    public Byte4 fileOffset;
    public Byte4 fileSize;
    public Byte4 maxVmProtection;
    public Byte4 initialVmProtection;
    public Byte4 sectionsNum;
    public Byte4 flags;


    public List<ARMLcSectionHeaderBytes> sectionHeaders = new ArrayList<>();

}
