package com.lwjfork.symbol.ios.model.arm;

import com.lwjfork.symbol.ios.model.arm.command.ARMLc;
import com.lwjfork.symbol.ios.model.arm.mach_header.ARMMachHeader;
import com.lwjfork.symbol.ios.model.common.base.BaseModel;
import lombok.Data;

@Data
public class ARMSymbol extends BaseModel {



    public ARMMachHeader machHeader;

    public ARMLc lc;






    @Override
    public String toString() {
        return "ARMSymbol{" +
                "machHeader=" + machHeader +
                ", lc=" + lc +
                ", useBytesCount=" + useBytesCount +
                ", offset='" + offset + '\'' +
                '}';
    }


}
