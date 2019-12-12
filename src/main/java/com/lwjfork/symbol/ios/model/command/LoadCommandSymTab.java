package com.lwjfork.symbol.ios.model.command;

import com.lwjfork.symbol.ios.model.base.BaseCommand;

public class LoadCommandSymTab extends BaseCommand {


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
                '}';
    }
}
