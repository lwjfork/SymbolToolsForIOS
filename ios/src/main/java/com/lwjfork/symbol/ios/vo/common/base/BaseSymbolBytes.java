package com.lwjfork.symbol.ios.vo.common.base;

import com.lwjfork.symbol.ios.vo.common.section.SectionContentBytes;
import com.lwjfork.symbol.tools.model.Byte4;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BaseSymbolBytes extends BaseBytes {


    public Byte4 cpuType;
    public Byte4 cpuSubType;

    public BytesCountBytes stringTable;


    public List<SectionContentBytes> section = new ArrayList<>();

}
