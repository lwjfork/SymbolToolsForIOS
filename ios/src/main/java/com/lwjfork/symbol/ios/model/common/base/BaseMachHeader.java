package com.lwjfork.symbol.ios.model.common.base;

import lombok.Data;

@Data
public abstract class BaseMachHeader extends BaseModel {

    public long magicNum;
    public long cpuType;
    public long cpuSubType;
    public long fileType;
    public long commandsNum;
    public long commandSize;
    public long flags;


    @Override
    public String toString() {
        return "BaseMachHeader{" +
                "magicNum=" + magicNum +
                ", cpuType=" + cpuType +
                ", cpuSubType=" + cpuSubType +
                ", fileType=" + fileType +
                ", commandsNum=" + commandsNum +
                ", commandSize=" + commandSize +
                ", flags=" + flags +
                '}';
    }
}
