package com.lwjfork.symbol.tools.mapper;

import com.lwjfork.symbol.tools.model.*;

import java.math.BigInteger;


public class Bytes2BigIntegerMapper {

    public static final Bytes2BigIntegerMapper INSTANCE = new Bytes2BigIntegerMapper();

    public BigInteger byte1ToBigInteger(Byte1 bytes) {
        return bytes.convertBitInteger();
    }


    public BigInteger byte2ToBigInteger(Byte2 bytes) {
        return bytes.convertBitInteger();
    }


    public BigInteger byte4ToBigInteger(Byte4 bytes) {
        return bytes.convertBitInteger();
    }


    public BigInteger byte8ToBigInteger(Byte8 bytes) {
        return bytes.convertBitInteger();
    }


    public BigInteger byte16ToBigInteger(Byte16 bytes) {
        return bytes.convertBitInteger();
    }


    public BigInteger byte32ToBigInteger(Byte32 bytes) {
        return bytes.convertBitInteger();
    }


    public BigInteger byte64ToBigInteger(Byte64 bytes) {
        return bytes.convertBitInteger();
    }
}
