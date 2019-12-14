package com.lwjfork.symbol.ios.reader.arm64;


import com.lwjfork.symbol.ios.mapper.arm64.ARM64SymbolMapper;
import com.lwjfork.symbol.ios.model.arm64.ARM64Symbol;
import com.lwjfork.symbol.ios.reader.arm64.command.ARM64LcReader;
import com.lwjfork.symbol.ios.reader.arm64.header.ARM64MachHeaderReader;
import com.lwjfork.symbol.ios.reader.common.base.BaseAssignBytesCountReader;
import com.lwjfork.symbol.ios.vo.arm64.ARM64SymbolBytes;
import com.lwjfork.symbol.tools.mapper.Bytes2LongMapper;
import com.lwjfork.symbol.tools.model.Byte4;
import com.lwjfork.symbol.tools.uitls.StrUtils;

import java.io.IOException;
import java.io.RandomAccessFile;

public class ARM64SymbolReader extends BaseAssignBytesCountReader<ARM64Symbol, ARM64SymbolBytes> {


    public ARM64SymbolReader(Byte4 magicBytes, RandomAccessFile accessFile, long maxBytesCount) {
        super(StrUtils.hexStr2Long(magicBytes.offset), accessFile, maxBytesCount);
    }

    @Override
    protected void writeOffsetAndBytesCount(ARM64SymbolBytes bytes) {
        bytes.offsetOfBytes = getOffsetHexStr();
        bytes.useBytesCount = maxBytesCount;
    }

    @Override
    protected ARM64Symbol convertBytes2Model(ARM64SymbolBytes bytes) {
        return ARM64SymbolMapper.INSTANCE.bytes2Model(bytes);
    }

    @Override
    protected ARM64SymbolBytes readBytes() throws IOException {
        accessFile.seek(offset);
        ARM64SymbolBytes armSymbolBytes = new ARM64SymbolBytes();
        armSymbolBytes.machHeader = new ARM64MachHeaderReader(offset, accessFile).readBytesFinal();
        long commandNum = Bytes2LongMapper.INSTANCE.byte4ToLong(armSymbolBytes.machHeader.commandsNum);
        long commandSize = Bytes2LongMapper.INSTANCE.byte4ToLong(armSymbolBytes.machHeader.commandSize);
        long lcOffset = getOffset() + armSymbolBytes.machHeader.useBytesCount;
        armSymbolBytes.lc = new ARM64LcReader(lcOffset, commandNum, accessFile, commandSize).readBytesFinal();
        return armSymbolBytes;
    }

}
