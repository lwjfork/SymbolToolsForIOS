package com.lwjfork.symbol.ios.model.common.base;

import lombok.Data;

@Data
public abstract class BaseCommand extends BaseModel{

    // 4 字节
    public long command;
    // 4 字节
    public long commandSize;


}
