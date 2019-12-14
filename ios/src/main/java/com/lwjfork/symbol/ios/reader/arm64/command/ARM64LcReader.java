package com.lwjfork.symbol.ios.reader.arm64.command;

import com.lwjfork.symbol.ios.constant.LoadCommandType;
import com.lwjfork.symbol.ios.mapper.arm64.ARM64LcMapper;
import com.lwjfork.symbol.ios.model.arm64.command.ARM64Lc;
import com.lwjfork.symbol.ios.reader.common.base.BaseAssignBytesCountReader;
import com.lwjfork.symbol.ios.reader.common.command.LcSymTabReader;
import com.lwjfork.symbol.ios.reader.common.command.LcUUIDReader;
import com.lwjfork.symbol.ios.vo.arm64.ARM64SymbolBytes;
import com.lwjfork.symbol.ios.vo.arm64.command.ARM64LcBytes;
import com.lwjfork.symbol.tools.mapper.Bytes2LongMapper;
import com.lwjfork.symbol.tools.model.Byte4;

import java.io.IOException;
import java.io.RandomAccessFile;

public class ARM64LcReader extends BaseAssignBytesCountReader<ARM64Lc, ARM64LcBytes> {


    ARM64LcMapper lcMapper = ARM64LcMapper.INSTANCE;

    long commandsNum;

    ARM64SymbolBytes armSymbolBytes;

    public ARM64LcReader(long offset, long commandsNum, RandomAccessFile accessFile, long maxBytesCount, ARM64SymbolBytes armSymbolBytes) {
        super(offset, accessFile, maxBytesCount);
        this.commandsNum = commandsNum;
        this.armSymbolBytes = armSymbolBytes;
    }

    @Override
    protected void writeOffsetAndBytesCount(ARM64LcBytes bytes) {
        bytes.offsetHexStrOfBytes = getOffsetHexStr();
        bytes.offsetOfBytes = getOffset();
        bytes.useBytesCount = maxBytesCount;
    }

    @Override
    protected ARM64Lc convertBytes2Model(ARM64LcBytes bytes) {
        return lcMapper.bytes2Model(bytes);
    }

    @Override
    protected ARM64LcBytes readBytes() throws IOException {
        accessFile.seek(offset);
        ARM64LcBytes lcBytes = new ARM64LcBytes();
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
                lcBytes.lcSymTab = new LcSymTabReader(commandOffset, accessFile, commandSize, armSymbolBytes).readBytesFinal();
            } else if (commandType == LoadCommandType.LC_SEGMENT_64) {
                lcBytes.segments.add(new ARM64LcSegmentReader(commandOffset, accessFile, commandSize, armSymbolBytes).readBytesFinal());
            }
            commandOffset = commandOffset + commandSize;
        }
        return lcBytes;
    }


}
