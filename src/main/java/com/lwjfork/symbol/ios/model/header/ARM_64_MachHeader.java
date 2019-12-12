package com.lwjfork.symbol.ios.model.header;

import com.lwjfork.symbol.ios.model.base.BaseMachHeader;

public class ARM_64_MachHeader extends BaseMachHeader {


    public long reserved;


    @Override
    public String toString() {
        return "ARM_64_MachHeader{" +
                "magicNum=" + magicNum +
                ", cpuType=" + cpuType +
                ", cpuSubType=" + cpuSubType +
                ", fileType=" + fileType +
                ", commandsNum=" + commandsNum +
                ", commandSize=" + commandSize +
                ", flags=" + flags +
                ", reserved=" + reserved +
                ", useBytesCount=" + useBytesCount +
                '}';
    }

}
