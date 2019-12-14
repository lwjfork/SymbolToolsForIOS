package com.lwjfork.symbol.ios.vo.common.fat;

import com.lwjfork.symbol.ios.vo.common.base.BaseBytes;
import com.lwjfork.symbol.tools.model.Byte4;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * FatHeader
 */
@Data
public class FatHeaderBytes extends BaseBytes {

    /**
     * Magic Number
     */
    public Byte4 magicNum;

    /**
     * CPU number
     */
    public Byte4 archNum;

    /**
     * CPU info
     */
    public List<FatArchHeaderBytes> arches = new ArrayList<>();



}
