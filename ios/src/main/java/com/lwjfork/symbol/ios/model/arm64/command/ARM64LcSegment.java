package com.lwjfork.symbol.ios.model.arm64.command;

import com.lwjfork.symbol.ios.model.common.base.BaseCommand;
import lombok.Data;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Data
public class ARM64LcSegment extends BaseCommand {


    public String segmentName;
    public BigInteger vmAddress;
    public BigInteger vmSize;
    public BigInteger fileOffset;
    public BigInteger fileSize;
    public long maxVmProtection;
    public long initialVmProtection;
    public long sectionsNum;
    public long flags;


    public List<ARM64LcSectionHeader> sectionHeaders = new ArrayList<>();

    @Override
    public String toString() {
        return "ARM64LcSegment{" +
                "segmentName='" + segmentName + '\'' +
                ", vmAddress=" + vmAddress +
                ", vmSize=" + vmSize +
                ", fileOffset=" + fileOffset +
                ", fileSize=" + fileSize +
                ", maxVmProtection=" + maxVmProtection +
                ", initialVmProtection=" + initialVmProtection +
                ", sectionsNum=" + sectionsNum +
                ", flags=" + flags +
                ", sectionHeaders=" + sectionHeaders +
                ", command=" + command +
                ", commandSize=" + commandSize +
                ", useBytesCount=" + useBytesCount +
                ", offsetOfBytes='" + offsetOfBytes + '\'' +
                '}';
    }
}

