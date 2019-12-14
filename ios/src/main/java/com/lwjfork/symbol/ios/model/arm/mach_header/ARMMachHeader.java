package com.lwjfork.symbol.ios.model.arm.mach_header;

import com.lwjfork.symbol.ios.model.common.base.BaseMachHeader;
import lombok.Data;

@Data
public class ARMMachHeader extends BaseMachHeader {


    @Override
    public String toString() {
        return "MachHeader{" +
                "offset=" + offset +
                ", magicNum=" + magicNum +
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
