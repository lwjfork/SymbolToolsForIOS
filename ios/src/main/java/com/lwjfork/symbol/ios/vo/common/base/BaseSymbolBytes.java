package com.lwjfork.symbol.ios.vo.common.base;

import lombok.Data;

import java.util.ArrayList;

@Data
public class BaseSymbolBytes extends BaseBytes {



    public BytesCountBytes stringTable;


    public ArrayList<BytesCountBytes> section = new ArrayList<>();

}
