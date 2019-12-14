package com.lwjfork.symbol.ios.model.arm.command;

import com.lwjfork.symbol.ios.model.common.base.BaseModel;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ARMLcSectionHeader extends BaseModel {

    public String segmentName;
    public String sectionName;
    public long address;
    public long size;
    public long offset;
    public long alignment;
    public long rlOffset;  // Relocations Offset
    public long rlNum;  // Number of reloactions
    public long flags;
    public long reserved1OrIndexOfIS; // reserved1 or Indirect of Sym Index
    public long reserved2OrSizeOfStubs;  //  reserved2 or Size of Stubs




    @Override
    public String toString() {
        return "ARMLcSectionHeader{" +
                "segmentName='" + segmentName + '\'' +
                ", sectionName='" + sectionName + '\'' +
                ", address=" + address +
                ", size=" + size +
                ", offset=" + offset +
                ", alignment=" + alignment +
                ", rlOffset=" + rlOffset +
                ", rlNum=" + rlNum +
                ", flags=" + flags +
                ", reserved1OrIndexOfIS=" + reserved1OrIndexOfIS +
                ", reserved2OrSizeOfStubs=" + reserved2OrSizeOfStubs +
                ", useBytesCount=" + useBytesCount +
                ", offsetOfBytes='" + offsetOfBytes + '\'' +
                '}';
    }
}
