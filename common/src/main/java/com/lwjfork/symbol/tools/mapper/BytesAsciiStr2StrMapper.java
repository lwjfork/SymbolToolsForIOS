package com.lwjfork.symbol.tools.mapper;

import com.lwjfork.symbol.tools.model.*;
import com.lwjfork.symbol.tools.uitls.StrUtils;


public class BytesAsciiStr2StrMapper {

    public static final BytesAsciiStr2StrMapper INSTANCE = new BytesAsciiStr2StrMapper();

    public String byte1AsciiToStr(Byte1 bytes) {
        return StrUtils.asciiStrToString(bytes.convert2HexStr(), true);
    }


    public String byte2AsciiToStr(Byte2 bytes) {
        return StrUtils.asciiStrToString(bytes.convert2HexStr(), true);
    }


    public String byte4AsciiToStr(Byte4 bytes) {
        return StrUtils.asciiStrToString(bytes.convert2HexStr(), true);
    }


    public String byte8AsciiToStr(Byte8 bytes) {
        return StrUtils.asciiStrToString(bytes.convert2HexStr(), true);
    }


    public String byte16AsciiToStr(Byte16 bytes) {
        return StrUtils.asciiStrToString(bytes.convert2HexStr(), true);
    }


    public String byte32AsciiToStr(Byte32 bytes) {
        return StrUtils.asciiStrToString(bytes.convert2HexStr(), true);
    }


    public String byte64AsciiToStr(Byte64 bytes) {
        return StrUtils.asciiStrToString(bytes.convert2HexStr(), true);
    }
}
