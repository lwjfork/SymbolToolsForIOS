package com.lwjfork.symbol.ios.model.arm.command;

import com.lwjfork.symbol.ios.model.common.base.BaseCommand;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ARMLcSegment extends BaseCommand {

    public String segmentName;
    public long vmAddress;
    public long vmSize;
    public long fileOffset;
    public long fileSize;
    public long maxVmProtection;
    public long initialVmProtection;
    public long sectionsNum;
    public long flags;


    public List<ARMLcSectionHeader> sectionHeaders = new ArrayList<>();

    @Override
    public String toString() {
        return "ARMLcSegment{" +
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
