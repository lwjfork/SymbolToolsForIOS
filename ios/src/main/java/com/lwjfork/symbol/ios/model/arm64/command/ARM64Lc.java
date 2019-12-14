package com.lwjfork.symbol.ios.model.arm64.command;

import com.lwjfork.symbol.ios.model.common.base.BaseModel;
import com.lwjfork.symbol.ios.model.common.command.LcSymTab;
import com.lwjfork.symbol.ios.model.common.command.LcUuid;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ARM64Lc extends BaseModel {

    public LcUuid lcUUID;
    public LcSymTab lcSymTab;

    public List<ARM64LcSegment> segments = new ArrayList<>();

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
