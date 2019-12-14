package com.lwjfork.symbol.ios.model.arm;

import com.lwjfork.symbol.ios.model.arm.command.ARMLc;
import com.lwjfork.symbol.ios.model.arm.mach_header.ARMMachHeader;
import com.lwjfork.symbol.ios.model.common.base.BaseModel;
import com.lwjfork.symbol.ios.model.common.base.BytesCountStr;
import com.lwjfork.symbol.ios.model.common.section.SectionContent;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ARMSymbol extends BaseModel {


    public ARMMachHeader machHeader;

    public ARMLc lc;


    public BytesCountStr stringTable;


    public List<SectionContent> section = new ArrayList<>();


    @Override
    public String toString() {
        return "ARMSymbol{" +
                "machHeader=" + machHeader +
                ", lc=" + lc +
                ", useBytesCount=" + useBytesCount +
                ", offset='" + offsetOfBytes + '\'' +
                ", stringTable='" + stringTable + '\'' +
                ", section=" + section +
                '}';
    }


}
