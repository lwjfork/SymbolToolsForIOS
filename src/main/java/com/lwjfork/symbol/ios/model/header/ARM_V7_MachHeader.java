package com.lwjfork.symbol.ios.model.header;

import com.lwjfork.symbol.ios.model.base.BaseMachHeader;

public class ARM_V7_MachHeader extends BaseMachHeader {


    @Override
    public String toString() {
        return "ARM_V7_MachHeader{" +
                "magicNum=" + magicNum +
                ", cpuType=" + cpuType +
                ", cpuSubType=" + cpuSubType +
                ", fileType=" + fileType +
                ", commandsNum=" + commandsNum +
                ", commandSize=" + commandSize +
                ", flags=" + flags +
                ", useBytesCount=" + useBytesCount +
                '}';
    }

}
