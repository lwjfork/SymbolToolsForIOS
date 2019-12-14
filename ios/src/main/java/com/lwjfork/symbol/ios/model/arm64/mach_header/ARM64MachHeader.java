package com.lwjfork.symbol.ios.model.arm64.mach_header;

import com.lwjfork.symbol.ios.model.common.base.BaseMachHeader;
import lombok.Data;

@Data
public class ARM64MachHeader extends BaseMachHeader {


    public long reserved;


    @Override
    public String toString() {
        return "MachHeader_64{" +
                "  offset=" + offsetOfBytes +
                ", magicNum=" + magicNum +
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
