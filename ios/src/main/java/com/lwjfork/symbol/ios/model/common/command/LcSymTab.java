package com.lwjfork.symbol.ios.model.common.command;

import com.lwjfork.symbol.ios.model.common.base.BaseCommand;
import lombok.Data;

@Data
public class LcSymTab extends BaseCommand {


    public long symbolTableOffset;
    public long symbolTableNum;

    public long stringTableOffset;
    public long stringTableSize;

    @Override
    public String toString() {
        return "LoadCommandSymTab{" +
                "symbolTableOffset=" + symbolTableOffset +
                ", symbolTableNum=" + symbolTableNum +
                ", stringTableOffset=" + stringTableOffset +
                ", stringTableSize=" + stringTableSize +
                ", command=" + command +
                ", commandSize=" + commandSize +
                ", useBytesCount=" + useBytesCount +
                ", offset='" + offsetOfBytes + '\'' +
                '}';
    }
}
