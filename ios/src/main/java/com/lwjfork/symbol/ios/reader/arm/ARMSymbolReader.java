package com.lwjfork.symbol.ios.reader.arm;


import com.lwjfork.symbol.ios.constant.LoadCommandType;
import com.lwjfork.symbol.ios.mapper.arm.ARMSymbolMapper;
import com.lwjfork.symbol.ios.model.arm.ARMSymbol;
import com.lwjfork.symbol.ios.reader.arm.command.ARMLcReader;
import com.lwjfork.symbol.ios.reader.arm.header.ARMMachHeaderReader;
import com.lwjfork.symbol.ios.reader.common.base.BaseAssignBytesCountReader;
import com.lwjfork.symbol.ios.reader.common.base.BytesCountReader;
import com.lwjfork.symbol.ios.vo.arm.ARMSymbolBytes;
import com.lwjfork.symbol.ios.vo.common.base.BytesCountBytes;
import com.lwjfork.symbol.ios.vo.common.command.LcSymTabBytes;
import com.lwjfork.symbol.tools.mapper.Bytes2LongMapper;
import com.lwjfork.symbol.tools.model.Byte4;
import com.lwjfork.symbol.tools.uitls.StrUtils;

import java.io.IOException;
import java.io.RandomAccessFile;

public class ARMSymbolReader extends BaseAssignBytesCountReader<ARMSymbol, ARMSymbolBytes> {


    public ARMSymbolReader(Byte4 magicBytes, RandomAccessFile accessFile, long maxBytesCount) {
        super(StrUtils.hexStr2Long(magicBytes.offsetHexStrOfBytes), accessFile, maxBytesCount);
    }

    @Override
    protected ARMSymbol convertBytes2Model(ARMSymbolBytes bytes) {
        return ARMSymbolMapper.INSTANCE.bytes2Model(bytes);
    }

    @Override
    protected void writeOffsetAndBytesCount(ARMSymbolBytes bytes) {
        bytes.offsetHexStrOfBytes = getOffsetHexStr();
        bytes.offsetOfBytes = getOffset();
        bytes.useBytesCount = maxBytesCount;
    }

    @Override
    protected ARMSymbolBytes readBytes() throws IOException {
        accessFile.seek(offset);
        ARMSymbolBytes armSymbolBytes = new ARMSymbolBytes();

        armSymbolBytes.machHeader = new ARMMachHeaderReader(offset, accessFile).readBytesFinal();

        long commandNum = Bytes2LongMapper.INSTANCE.byte4ToLong(armSymbolBytes.machHeader.commandsNum);
        long commandSize = Bytes2LongMapper.INSTANCE.byte4ToLong(armSymbolBytes.machHeader.commandSize);
        long lcOffset = getOffset() + armSymbolBytes.machHeader.useBytesCount;
        armSymbolBytes.lc = new ARMLcReader(lcOffset, commandNum, accessFile, commandSize).readBytesFinal();
        readDetailInfoForSymTab(armSymbolBytes);
        return armSymbolBytes;
    }


    private void readDetailInfoForSymTab(ARMSymbolBytes armSymbolBytes) throws IOException {
        if (armSymbolBytes.lc != null && armSymbolBytes.lc.lcSymTab != null) {
            readDetailInfoForSymTab(armSymbolBytes.lc.lcSymTab, armSymbolBytes);
        }
    }

    private void readDetailInfoForSymTab(LcSymTabBytes symTabCommand, ARMSymbolBytes armSymbolBytes) throws IOException {
        long commandType = Bytes2LongMapper.INSTANCE.byte4ToLong(symTabCommand.command);
        if (commandType != LoadCommandType.LC_SYMTAB) {
            return;
        }
        // 相对索引
        long symbolTableOppositeOffset = Bytes2LongMapper.INSTANCE.byte4ToLong(symTabCommand.stringTableOffset);
        if (symbolTableOppositeOffset > 0L) {
            long symbolTableOffset = symbolTableOppositeOffset + offset;
            long symbolTableSize = Bytes2LongMapper.INSTANCE.byte4ToLong(symTabCommand.stringTableSize);
            armSymbolBytes.stringTable = readDetailStringTable(symbolTableOffset, accessFile, symbolTableSize);
        }
    }

    private BytesCountBytes readDetailStringTable(long symbolTableOffset, RandomAccessFile accessFile, long symbolTableSize) throws IOException {
        BytesCountReader bytesCountReader = new BytesCountReader(symbolTableOffset, accessFile, symbolTableSize);
        return bytesCountReader.readBytesFinal();
    }

}
