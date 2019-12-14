package com.lwjfork.symbol.ios.model.common.base;

import lombok.Data;

@Data
public abstract class BaseSectionHeader extends BaseModel {

    // 16 字节
    public String sectionName;
    // 16 字节
    public String segmentName;
    // 4 字节
    public long address;
    // 4 字节
    public long size;
    // 4 字节
    public long offset;
    // 4 字节
    public long alignment;
    // 4 字节
    public long relocationsOffset;
    // 4 字节
    public long relocationsNum;
    // 4 字节
    public long flags;

    // 4 字节
    public long reserved2;


}
