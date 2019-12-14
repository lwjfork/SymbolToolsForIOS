package com.lwjfork.symbol.ios.model.arm64.command;

import com.lwjfork.symbol.ios.model.common.base.BaseCommand;
import lombok.Data;

import java.math.BigInteger;

@Data
public class ARM64LcSegment extends BaseCommand {

    // 16 字节
    public String segmentName;

    // 8 字节
    public BigInteger VMAddress;

    //  8 字节
    public BigInteger VMSize;

    //  8 字节
    public BigInteger fileOffset;

    //  8 字节
    public BigInteger fileSize;

    // 4 字节
    public long maxVMProtection;
    // 4 字节
    public long initialVMProtection;
    // 4 字节
    public long sectionsNum;
    // 4 字节
    public long flags;


}
