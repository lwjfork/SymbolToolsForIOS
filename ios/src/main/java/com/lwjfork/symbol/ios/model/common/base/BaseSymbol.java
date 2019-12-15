package com.lwjfork.symbol.ios.model.common.base;

import com.lwjfork.symbol.ios.model.common.section.SectionContent;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseSymbol extends BaseModel {

    public long cpuType;

    public long cpuSubType;


    public BytesCountStr stringTable;


    public List<SectionContent> section = new ArrayList<>();

}
