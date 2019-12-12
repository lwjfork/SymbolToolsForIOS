package com.lwjfork.symbol.ios.model.header;

import com.lwjfork.symbol.ios.model.base.BaseModel;

import java.util.ArrayList;
import java.util.List;

/**
 * FatHeader
 */
public class FatHeader extends BaseModel {

    /**
     * Magic Number
     */
    public long magicNum;

    /**
     * CPU number
     */
    public long archNum = 0;


    /**
     * CPU info
     */
    public List<FatArchHeader> arches = new ArrayList<>();


    @Override
    public String toString() {
        return "FatHeader{" +
                "magicNum=" + magicNum +
                ", archNum=" + archNum +
                ", arches=" + arches +
                ", useBytesCount=" + useBytesCount +
                '}';
    }
}
