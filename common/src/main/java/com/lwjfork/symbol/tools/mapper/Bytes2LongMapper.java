package com.lwjfork.symbol.tools.mapper;

import com.lwjfork.symbol.tools.model.*;


public class Bytes2LongMapper {

    public static final Bytes2LongMapper INSTANCE = new Bytes2LongMapper();


    public long byte1ToLong(Byte1 bytes) {
        return bytes.convert2Long();
    }

    public long byte2ToLong(Byte2 bytes) {
        return bytes.convert2Long();
    }


    public long byte4ToLong(Byte4 bytes) {
        return bytes.convert2Long();
    }


    public long byte8ToLong(Byte8 bytes) {
        return bytes.convert2Long();
    }

    public long byte16ToLong(Byte16 bytes) {
        return bytes.convert2Long();
    }


    public long byte32ToLong(Byte32 bytes) {
        return bytes.convert2Long();
    }


    public long byte64ToLong(Byte64 bytes) {
        return bytes.convert2Long();
    }
    public long bytesToLong(BytesCount bytes) {
        return bytes.convert2Long();
    }
}
