package com.lwjfork.symbol.ios.vo.common.base;

import com.lwjfork.symbol.ios.vo.common.section.SectionContentBytes;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BaseSymbolBytes extends BaseBytes {



    public BytesCountBytes stringTable;


    public List<SectionContentBytes> section = new ArrayList<>();

}
