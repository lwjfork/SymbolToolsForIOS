package com.lwjfork.symbol.ios.model.common.base;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BaseCommandSegment<T extends BaseSectionHeader> extends BaseCommand {

    // 16 字节
    public String segmentName;

    // 4 字节
    public long VMAddress;


    // 4 字节
    public long VMSize;

    // 4 字节
    public long fileOffset;

    // 4 字节
    public long fileSize;

    // 4 字节
    public long maxVMProtection;
    // 4 字节
    public long initialVMProtection;
    // 4 字节
    public long sectionsNum;
    // 4 字节
    public long flags;

    // 个数位置  根据 sectionsNum 计算得到值
    public List<T> sectionHeaders = new ArrayList<>();

    @Override
    public String toString() {
        return "LoadCommandSegment{" +
                "segmentName='" + segmentName + '\'' +
                ", VMAddress=" + VMAddress +
                ", VMSize=" + VMSize +
                ", fileOffset=" + fileOffset +
                ", fileSize=" + fileSize +
                ", maxVMProtection=" + maxVMProtection +
                ", initialVMProtection=" + initialVMProtection +
                ", sectionsNum=" + sectionsNum +
                ", flags=" + flags +
                ", sectionHeaders=" + sectionHeaders +
                ", command=" + command +
                ", commandSize=" + commandSize +
                ", useBytesCount=" + useBytesCount +
                '}';
    }
}
