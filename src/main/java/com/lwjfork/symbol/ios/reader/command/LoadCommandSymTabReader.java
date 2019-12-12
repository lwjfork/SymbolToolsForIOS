package com.lwjfork.symbol.ios.reader.command;

import com.lwjfork.symbol.ios.model.command.LoadCommandSymTab;
import com.lwjfork.symbol.ios.model.command.LoadCommandUUID;
import com.lwjfork.symbol.ios.reader.base.BaseAssignBytesCountReader;

import java.io.IOException;
import java.io.RandomAccessFile;

public class LoadCommandSymTabReader extends BaseAssignBytesCountReader<LoadCommandSymTab> {

    public LoadCommandSymTabReader(long offset, RandomAccessFile accessFile, long maxBytesCount) {
        super(offset, accessFile,maxBytesCount);
    }

    @Override
    public LoadCommandSymTab read() throws IOException {

        accessFile.seek(offset);
        LoadCommandSymTab symTab = new LoadCommandSymTab();
        symTab.command = read4Bytes2Long(true);
        symTab.commandSize = read4Bytes2Long(true);
        symTab.symbolTableOffset = read4Bytes2Long(true);
        symTab.symbolTableNum =read4Bytes2Long(true);
        symTab.stringTableOffset = read4Bytes2Long(true);
        symTab.stringTableSize = read4Bytes2Long(true);

        return symTab;
    }
}
