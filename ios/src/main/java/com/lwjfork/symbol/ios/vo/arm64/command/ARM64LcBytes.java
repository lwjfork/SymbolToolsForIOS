package com.lwjfork.symbol.ios.vo.arm64.command;

import com.lwjfork.symbol.ios.vo.common.base.BaseBytes;
import com.lwjfork.symbol.ios.vo.common.command.LcSymTabBytes;
import com.lwjfork.symbol.ios.vo.common.command.LcUuidBytes;

import java.util.ArrayList;
import java.util.List;

public class ARM64LcBytes extends BaseBytes {

    public LcUuidBytes lcUUID;
    public LcSymTabBytes lcSymTab;

    public List<ARM64LcSegmentBytes> segments = new ArrayList<>();

    @Override
    public String toString() {
        return "LoadCommand{" +
                "lcUUID=" + lcUUID +
                ", lcSymTab=" + lcSymTab +
                ", segments=" + segments +
                ", useBytesCount=" + useBytesCount +
                '}';
    }
}
