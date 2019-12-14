package com.lwjfork.symbol.ios.model.common.base;

import lombok.Data;

@Data
public abstract class BaseModel {

    public long useBytesCount;

    public String offsetHexStrOfBytes;

    public long offsetOfBytes;

}
