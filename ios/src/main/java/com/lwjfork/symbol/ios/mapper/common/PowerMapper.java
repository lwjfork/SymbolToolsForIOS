package com.lwjfork.symbol.ios.mapper.common;


import com.lwjfork.symbol.tools.mapper.Bytes2PowerMapper;
import com.lwjfork.symbol.tools.model.*;
import org.mapstruct.Named;

@Named(PowerMapper.PowerMapper)
public class PowerMapper {

    public static final String PowerMapper = "PowerMapper";


    public static final String byte1ToPower = "byte1ToPower";
    public static final String byte2ToPower = "byte2ToPower";
    public static final String byte4ToPower = "byte4ToPower";
    public static final String byte8ToPower = "byte8ToPower";
    public static final String byte16ToPower = "byte16ToPower";
    public static final String byte32ToPower = "byte32ToPower";
    public static final String byte64ToPower = "byte64ToPower";
    public static final String bytesToPower = "bytesToPower";

    @Named(byte1ToPower)
    public long byte1ToPower(Byte1 bytes) {
        return Bytes2PowerMapper.INSTANCE.byte1ToPower(bytes);
    }

    @Named(byte2ToPower)
    public long byte2ToPower(Byte2 bytes) {
        return Bytes2PowerMapper.INSTANCE.byte2ToPower(bytes);
    }

    @Named(byte4ToPower)
    public long byte4ToPower(Byte4 bytes) {
        return Bytes2PowerMapper.INSTANCE.byte4ToPower(bytes);
    }

    @Named(byte8ToPower)
    public long byte8ToPower(Byte8 bytes) {
        return Bytes2PowerMapper.INSTANCE.byte8ToPower(bytes);
    }

    @Named(byte16ToPower)
    public long byte16ToPower(Byte16 bytes) {
        return Bytes2PowerMapper.INSTANCE.byte16ToPower(bytes);
    }

    @Named(byte32ToPower)
    public long byte32ToPower(Byte32 bytes) {
        return Bytes2PowerMapper.INSTANCE.byte32ToPower(bytes);
    }

    @Named(byte64ToPower)
    public long byte64ToPower(Byte64 bytes) {
        return Bytes2PowerMapper.INSTANCE.byte64ToPower(bytes);
    }

    @Named(bytesToPower)
    public long bytesToPower(BytesCount bytes) {
        return Bytes2PowerMapper.INSTANCE.bytesToPower(bytes);
    }
}
