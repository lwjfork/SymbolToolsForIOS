package com.lwjfork.symbol.ios.model.common.base;

import lombok.Data;

@Data
public class BytesCountStr extends BaseModel {

    public String content;


    @Override
    public String toString() {
        return "BytesCountStr{" +
                "content='" + content + '\'' +
                ", useBytesCount=" + useBytesCount +
                ", offsetOfBytes='" + offsetOfBytes + '\'' +
                '}';
    }
}
