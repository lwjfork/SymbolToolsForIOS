package com.lwjfork.symbol.ios.model.common.base;

import lombok.Data;

@Data
public class BytesCountStr extends BaseModel {

    public String bytes;


    @Override
    public String toString() {
        return "BytesCountStr{" +
                "bytes='" + bytes + '\'' +
                ", useBytesCount=" + useBytesCount +
                ", offsetOfBytes='" + offsetOfBytes + '\'' +
                '}';
    }
}
