package com.lwjfork.symbol.ios.model.arm;

import com.lwjfork.symbol.ios.model.arm.command.ARMLc;
import com.lwjfork.symbol.ios.model.arm.mach_header.ARMMachHeader;
import com.lwjfork.symbol.ios.model.common.base.BaseModel;
import com.lwjfork.symbol.ios.model.common.base.BaseSymbol;
import com.lwjfork.symbol.ios.model.common.base.BytesCountStr;
import com.lwjfork.symbol.ios.model.common.section.SectionContent;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ARMSymbol extends BaseSymbol {


    public ARMMachHeader machHeader;

    public ARMLc lc;





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
