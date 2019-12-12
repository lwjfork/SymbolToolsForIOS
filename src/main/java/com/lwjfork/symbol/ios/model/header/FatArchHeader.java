package com.lwjfork.symbol.ios.model.header;

import com.lwjfork.symbol.ios.model.base.BaseModel;

public class FatArchHeader extends BaseModel {

    public long cpuType;
    public long cpuSubType;
    public long symbolsOffset;
    public long symbolsSize;
    public long symbolsAlign;


    @Override
    public String toString() {
        return "FatArchHeader{" +
                "cpuType=" + cpuType +
                ", cpuSubType=" + cpuSubType +
                ", symbolsOffset=" + symbolsOffset +
                ", symbolsSize=" + symbolsSize +
                ", symbolsAlign=" + symbolsAlign +
                ", useBytesCount=" + useBytesCount +
                '}';
    }
}
