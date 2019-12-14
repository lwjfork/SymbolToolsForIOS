package com.lwjfork.symbol.ios.model.common.base;

import lombok.Data;

@Data
public class BaseSegment extends BaseCommand{

    public String segmentName;

    public long VMAddress;

    public long VMSize;

    public long fileOffset;

    public long fileSize;

    public  long maxVMProtection;

    public long initialVMProtection;

    public long sectionsNum;


    public long flags;
}
