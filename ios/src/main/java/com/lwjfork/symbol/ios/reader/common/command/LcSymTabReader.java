package com.lwjfork.symbol.ios.reader.common.command;

import com.lwjfork.symbol.ios.constant.LoadCommandType;
import com.lwjfork.symbol.ios.mapper.common.BaseLcMapper;
import com.lwjfork.symbol.ios.model.common.command.LcSymTab;
import com.lwjfork.symbol.ios.reader.common.base.BaseAssignBytesCountReader;
import com.lwjfork.symbol.ios.vo.common.base.BaseSymbolBytes;
import com.lwjfork.symbol.ios.vo.common.base.BytesCountBytes;
import com.lwjfork.symbol.ios.vo.common.command.LcSymTabBytes;
import com.lwjfork.symbol.tools.mapper.Bytes2LongMapper;

import java.io.IOException;
import java.io.RandomAccessFile;

public class LcSymTabReader extends BaseAssignBytesCountReader<LcSymTab, LcSymTabBytes> {
    BaseSymbolBytes armSymbolBytes;

    public LcSymTabReader(long offset, RandomAccessFile accessFile, long maxByteCount, BaseSymbolBytes armSymbolBytes) {
        super(offset, accessFile, maxByteCount);
        this.armSymbolBytes = armSymbolBytes;
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
        readDetailInfoForSymTab(symTab);
        return symTab;
    }

    @Override
    protected void writeOffsetAndBytesCount(LcSymTabBytes bytes) {
        bytes.useBytesCount = maxBytesCount;
        bytes.offsetHexStrOfBytes = getOffsetHexStr();
        bytes.offsetOfBytes = getOffset();
    }

    private void readDetailInfoForSymTab(LcSymTabBytes symTab) throws IOException {
        readDetailInfoForSymTab(symTab, armSymbolBytes);
    }

    private void readDetailInfoForSymTab(LcSymTabBytes symTabCommand, BaseSymbolBytes armSymbolBytes) throws IOException {
        long commandType = Bytes2LongMapper.INSTANCE.byte4ToLong(symTabCommand.command);
        if (commandType != LoadCommandType.LC_SYMTAB) {
            return;
        }
        // 相对索引
        long symbolTableOppositeOffset = Bytes2LongMapper.INSTANCE.byte4ToLong(symTabCommand.stringTableOffset);
        if (symbolTableOppositeOffset > 0L) {
            long symbolTableOffset = symbolTableOppositeOffset + armSymbolBytes.offsetOfBytes;
            long symbolTableSize = Bytes2LongMapper.INSTANCE.byte4ToLong(symTabCommand.stringTableSize);
            armSymbolBytes.stringTable = readDetailStringTable(symbolTableOffset, accessFile, symbolTableSize);
        }
    }

    private BytesCountBytes readDetailStringTable(long symbolTableOffset, RandomAccessFile accessFile, long symbolTableSize) throws IOException {
        StringTableReader bytesCountReader = new StringTableReader(symbolTableOffset, accessFile, symbolTableSize);
        return bytesCountReader.readBytesFinal();
    }

    private void readDetailDetailSymTable() {

    }


}
