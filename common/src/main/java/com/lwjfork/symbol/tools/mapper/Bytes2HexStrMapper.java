package com.lwjfork.symbol.tools.mapper;

import com.lwjfork.symbol.tools.model.*;


public class Bytes2HexStrMapper {

    public static final  Bytes2HexStrMapper INSTANCE = new Bytes2HexStrMapper();

    public String byte1ToStr(Byte1 bytes) {
        return bytes.convert2HexStr();
    }


    public String byte2ToStr(Byte2 bytes) {
        return bytes.convert2HexStr();
    }

    public String byte4ToStr(Byte4 bytes) {
        return bytes.convert2HexStr();
    }


    public String byte8ToStr(Byte8 bytes) {
        return bytes.convert2HexStr();
    }


    public String byte16ToStr(Byte16 bytes) {
        return bytes.convert2HexStr();
    }


    public String byte32ToStr(Byte32 bytes) {
        return bytes.convert2HexStr();
    }

    public String byte64ToStr(Byte64 bytes) {
        return bytes.convert2HexStr();
    }
}
