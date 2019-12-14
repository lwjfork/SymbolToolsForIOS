package com.lwjfork.symbol.ios.reader.arm;


import com.lwjfork.symbol.ios.mapper.arm.ARMSymbolMapper;
import com.lwjfork.symbol.ios.model.arm.ARMSymbol;
import com.lwjfork.symbol.ios.reader.arm.command.ARMLcReader;
import com.lwjfork.symbol.ios.reader.arm.header.ARMMachHeaderReader;
import com.lwjfork.symbol.ios.reader.common.base.BaseAssignBytesCountReader;
import com.lwjfork.symbol.ios.vo.arm.ARMSymbolBytes;
import com.lwjfork.symbol.tools.mapper.Bytes2LongMapper;
import com.lwjfork.symbol.tools.model.Byte4;
import com.lwjfork.symbol.tools.uitls.StrUtils;

import java.io.IOException;
import java.io.RandomAccessFile;

public class ARMSymbolReader extends BaseAssignBytesCountReader<ARMSymbol, ARMSymbolBytes> {


    public ARMSymbolReader(Byte4 magicBytes, RandomAccessFile accessFile, long maxBytesCount) {
        super(StrUtils.hexStr2Long(magicBytes.offset), accessFile, maxBytesCount);
    }

    @Override
    protected ARMSymbol convertBytes2Model(ARMSymbolBytes bytes) {
        return ARMSymbolMapper.INSTANCE.bytes2Model(bytes);
    }

    @Override
    protected void writeOffsetAndBytesCount(ARMSymbolBytes bytes) {
        bytes.offset = getOffsetHexStr();
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


        return armSymbolBytes;
    }
}
