package com.lwjfork.symbol.ios.reader.symbol;

import com.lwjfork.symbol.ios.model.header.ARM_V7_MachHeader;
import com.lwjfork.symbol.ios.model.symbol.ARM_V7_Symbol;
import com.lwjfork.symbol.ios.reader.base.BaseSymbolsReader;

import java.io.IOException;
import java.io.RandomAccessFile;

public class ARM_V7_SymbolReader extends BaseSymbolsReader<
        ARM_V7_MachHeader,
//        LoadCommand,
        ARM_V7_Symbol> {

    public ARM_V7_SymbolReader(ARM_V7_MachHeader header, long offset, RandomAccessFile accessFile, long maxBytesCount) {
        super(header, offset, accessFile, maxBytesCount);
    }

    @Override
    protected ARM_V7_MachHeader readMachHeader() throws IOException {
//        ARM_V7_MachHeaderReader machHeaderReader = new ARM_V7_MachHeaderReader(0, blockIndex, accessFile);
//        ARM_V7_MachHeader header = machHeaderReader.read();
//        currentIndex = machHeaderReader.getCurrentIndex();
        return header;
    }

    @Override
    public ARM_V7_Symbol read() throws IOException {
        ARM_V7_Symbol symbol = new ARM_V7_Symbol();
        symbol.machHeader = readMachHeader();
        long contentOffset = getStartReadIndex() + header.useBytesCount;
        accessFile.seek(contentOffset);
        symbol.command = readLoadCommand();
        return symbol;
    }

//    @Override
//    protected LoadCommand readLoadCommand() throws IOException {
//        long commandOffset = getStartReadIndex() + header.useBytesCount;
//        long commandNum = header.commandsNum;
//        long commandSize = header.commandSize;
//        LoadCommandsReader loadCommandsReader = new LoadCommandsReader(commandOffset, commandNum, accessFile, commandSize);
//        LoadCommand loadCommand = loadCommandsReader.read();
//        loadCommand.useBytesCount = commandSize;
//        bytesCount += loadCommand.useBytesCount;
//        return loadCommand;
//    }
}
