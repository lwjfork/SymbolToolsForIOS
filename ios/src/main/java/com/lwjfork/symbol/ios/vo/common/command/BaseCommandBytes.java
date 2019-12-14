package com.lwjfork.symbol.ios.vo.common.command;

import com.lwjfork.symbol.ios.vo.common.base.BaseBytes;
import com.lwjfork.symbol.tools.model.Byte4;
import lombok.Data;

@Data
public abstract class BaseCommandBytes extends BaseBytes {

    // 4 字节
    public Byte4 command;
    // 4 字节
    public Byte4 commandSize;


}
