package com.lwjfork.symbol.ios.vo.arm.command;

import com.lwjfork.symbol.ios.vo.common.base.BaseBytes;
import com.lwjfork.symbol.ios.vo.common.command.LcSymTabBytes;
import com.lwjfork.symbol.ios.vo.common.command.LcUuidBytes;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ARMLcBytes extends BaseBytes {

    public LcUuidBytes lcUUID;
    public LcSymTabBytes lcSymTab;

    public List<ARMLcSegmentBytes> segments = new ArrayList<>();

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
