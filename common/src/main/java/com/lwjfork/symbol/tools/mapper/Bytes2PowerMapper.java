package com.lwjfork.symbol.tools.mapper;

import com.lwjfork.symbol.tools.model.*;


public class Bytes2PowerMapper {

    public static final Bytes2PowerMapper INSTANCE = new Bytes2PowerMapper();

    public long byte1ToPower(Byte1 bytes) {
        return (long) Math.pow(2, Bytes2LongMapper.INSTANCE.byte1ToLong(bytes));
    }


    public long byte2ToPower(Byte2 bytes) {
        return (long) Math.pow(2, Bytes2LongMapper.INSTANCE.byte2ToLong(bytes));
    }


    public long byte4ToPower(Byte4 bytes) {
        return (long) Math.pow(2, Bytes2LongMapper.INSTANCE.byte4ToLong(bytes));
    }


    public long byte8ToPower(Byte8 bytes) {
        return (long) Math.pow(2, Bytes2LongMapper.INSTANCE.byte8ToLong(bytes));
    }


    public long byte16ToPower(Byte16 bytes) {
        return (long) Math.pow(2, Bytes2LongMapper.INSTANCE.byte16ToLong(bytes));
    }


    public long byte32ToPower(Byte32 bytes) {
        return (long) Math.pow(2, Bytes2LongMapper.INSTANCE.byte32ToLong(bytes));
    }


    public long byte64ToPower(Byte64 bytes) {
        return (long) Math.pow(2, Bytes2LongMapper.INSTANCE.byte64ToLong(bytes));
    }

    public long bytesToPower(BytesCount bytes) {
        return (long) Math.pow(2, Bytes2LongMapper.INSTANCE.bytesToLong(bytes));
    }
}
