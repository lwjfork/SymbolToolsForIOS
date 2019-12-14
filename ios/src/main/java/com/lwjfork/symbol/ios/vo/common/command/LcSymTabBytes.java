package com.lwjfork.symbol.ios.vo.common.command;

import com.lwjfork.symbol.tools.model.Byte4;
import lombok.Data;

@Data
public class LcSymTabBytes extends BaseCommandBytes {


    public Byte4 symbolTableOffset;
    public Byte4 symbolTableNum;

    public Byte4 stringTableOffset;
    public Byte4 stringTableSize;


}
