package com.lwjfork.symbol.ios.model.arm.command;

import com.lwjfork.symbol.ios.model.common.base.BaseCommand;
import lombok.Data;

@Data
public class ARMLcSegment extends BaseCommand {

    // 16 字节
    public String segmentName;

    // 4  字节
    public long VMAddress;

    // 4  字节
    public long VMSize;

    // 4  字节
    public long fileOffset;

    // 4  字节
    public long fileSize;

    // 4 字节
    public long maxVMProtection;
    // 4 字节
    public long initialVMProtection;
    // 4 字节
    public long sectionsNum;
    // 4 字节
    public long flags;


}
