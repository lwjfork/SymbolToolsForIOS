package com.lwjfork.symbol.tools.mapper;

import com.lwjfork.symbol.tools.model.*;


public class Bytes2IntMapper {

    public static final Bytes2IntMapper INSTANCE = new Bytes2IntMapper();


    public int byte1ToInt(Byte1 bytes) {
        return bytes.convert2Int();
    }


    public int byte2ToInt(Byte2 bytes) {
        return bytes.convert2Int();
    }


    public int byte4ToInt(Byte4 bytes) {
        return bytes.convert2Int();
    }


    public int byte8ToInt(Byte8 bytes) {
        return bytes.convert2Int();
    }


    public int byte16ToInt(Byte16 bytes) {
        return bytes.convert2Int();
    }

    public int byte32ToInt(Byte32 bytes) {
        return bytes.convert2Int();
    }

    public int byte64ToInt(Byte64 bytes) {
        return bytes.convert2Int();
    }
}
