package com.lwjfork.symbol.ios.reader.common.command;

import com.lwjfork.symbol.ios.mapper.common.BaseLcMapper;
import com.lwjfork.symbol.ios.model.common.command.LcSymTab;
import com.lwjfork.symbol.ios.reader.common.base.BaseAssignBytesCountReader;
import com.lwjfork.symbol.ios.vo.common.command.LcSymTabBytes;

import java.io.IOException;
import java.io.RandomAccessFile;

public class LcSymTabReader extends BaseAssignBytesCountReader<LcSymTab, LcSymTabBytes> {

    public LcSymTabReader(long offset, RandomAccessFile accessFile, long maxByteCount) {
        super(offset, accessFile, maxByteCount);
    }

    @Override
    protected LcSymTab convertBytes2Model(LcSymTabBytes bytes) {
        return BaseLcMapper.INSTANCE.bytes2Model(bytes);
    }

    @Override
    protected LcSymTabBytes readBytes() throws IOException {
        accessFile.seek(offset);
        LcSymTabBytes symTab = new LcSymTabBytes();
        symTab.command = read4Bytes(true);
        symTab.commandSize = read4Bytes(true);
        symTab.symbolTableOffset = read4Bytes(true);
        symTab.symbolTableNum = read4Bytes(true);
        symTab.stringTableOffset = read4Bytes(true);
        symTab.stringTableSize = read4Bytes(true);
        return symTab;
    }

    @Override
    protected void writeOffsetAndBytesCount(LcSymTabBytes bytes) {
        bytes.useBytesCount = maxBytesCount;
        bytes.offset = getOffsetHexStr();
    }
}
