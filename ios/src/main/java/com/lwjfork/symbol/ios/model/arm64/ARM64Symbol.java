package com.lwjfork.symbol.ios.model.arm64;

import com.lwjfork.symbol.ios.model.arm64.command.ARM64Lc;
import com.lwjfork.symbol.ios.model.arm64.mach_header.ARM64MachHeader;
import com.lwjfork.symbol.ios.model.common.base.BaseModel;
import com.lwjfork.symbol.ios.model.common.base.BytesCountStr;
import lombok.Data;

import java.util.ArrayList;

@Data
public class ARM64Symbol extends BaseModel {


    public ARM64MachHeader machHeader;

    public ARM64Lc lc;


    public BytesCountStr stringTable;


    public ArrayList<BytesCountStr> section = new ArrayList<>();


    @Override
    public String toString() {
        return "ARM64Symbol{" +
                "machHeader=" + machHeader +
                ", lc=" + lc +
                ", useBytesCount=" + useBytesCount +
                ", offset='" + offsetOfBytes + '\'' +
                ", stringTable='" + stringTable + '\'' +
                ", section=" + section +
                '}';
    }
}
