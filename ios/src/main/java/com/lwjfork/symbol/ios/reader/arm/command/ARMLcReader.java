package com.lwjfork.symbol.ios.reader.arm.command;

import com.lwjfork.symbol.ios.constant.LoadCommandType;
import com.lwjfork.symbol.ios.mapper.arm.ARMLcMapper;
import com.lwjfork.symbol.ios.model.arm.command.ARMLc;
import com.lwjfork.symbol.ios.reader.common.base.BaseAssignBytesCountReader;
import com.lwjfork.symbol.ios.reader.common.command.LcSymTabReader;
import com.lwjfork.symbol.ios.reader.common.command.LcUUIDReader;
import com.lwjfork.symbol.ios.vo.arm.command.ARMLcBytes;
import com.lwjfork.symbol.tools.mapper.Bytes2LongMapper;
import com.lwjfork.symbol.tools.model.Byte4;

import java.io.IOException;
import java.io.RandomAccessFile;

public class ARMLcReader extends BaseAssignBytesCountReader<ARMLc, ARMLcBytes> {


    ARMLcMapper lcMapper = ARMLcMapper.INSTANCE;

    long commandsNum;

    public ARMLcReader(long offset, long commandsNum, RandomAccessFile accessFile, long maxBytesCount) {
        super(offset, accessFile, maxBytesCount);
        this.commandsNum = commandsNum;
    }

    @Override
    protected void writeOffsetAndBytesCount(ARMLcBytes bytes) {
        bytes.offset = getOffsetHexStr();
        bytes.useBytesCount = maxBytesCount;
    }

    @Override
    protected ARMLc convertBytes2Model(ARMLcBytes bytes) {
        return lcMapper.bytes2Model(bytes);
    }

    @Override
    protected ARMLcBytes readBytes() throws IOException {
        accessFile.seek(offset);
        ARMLcBytes lcBytes = new ARMLcBytes();
        long commandOffset = offset;
        for (long i = 0; i < commandsNum; i++) {
            accessFile.seek(commandOffset);
            Byte4 commandByte4 = read4Bytes(true);
            Byte4 commandSizeByte4 = read4Bytes(true);
            long commandType = Bytes2LongMapper.INSTANCE.byte4ToLong(commandByte4);
            long commandSize = Bytes2LongMapper.INSTANCE.byte4ToLong(commandSizeByte4);
            if (commandType == LoadCommandType.LC_UUID) { // UUID
                lcBytes.lcUUID = new LcUUIDReader(commandOffset, accessFile, commandSize).readBytesFinal();
            } else if (commandType == LoadCommandType.LC_SYMTAB) { // symTab
                lcBytes.lcSymTab = new LcSymTabReader(commandOffset, accessFile, commandSize).readBytesFinal();
            }


            commandOffset = commandOffset + commandSize;
        }
        return lcBytes;
    }

}
