package com.lwjfork.symbol.ios.reader.base;

import com.lwjfork.symbol.ios.model.base.BaseMachHeader;
import com.lwjfork.symbol.ios.model.base.BaseSymbol;
import com.lwjfork.symbol.ios.model.command.LoadCommand;
import com.lwjfork.symbol.ios.reader.command.LoadCommandsReader;

import java.io.IOException;
import java.io.RandomAccessFile;

public abstract class BaseSymbolsReader<
        MachHeader extends BaseMachHeader, // machHeader
//        Command extends LoadCommand, // machHeader
        Symbol extends BaseSymbol<MachHeader>>  // symbol
        extends BaseAssignBytesCountReader {

    protected MachHeader header;

    public BaseSymbolsReader(MachHeader header, long offset, RandomAccessFile accessFile, long bytesCount) {
        super(offset, accessFile, bytesCount);
        this.header = header;
    }

    protected abstract MachHeader readMachHeader() throws IOException;


//    protected abstract Command readLoadCommand() throws IOException;


    protected LoadCommand readLoadCommand() throws IOException {
        long commandOffset = getStartReadIndex() + header.useBytesCount;
        long commandNum = header.commandsNum;
        long commandSize = header.commandSize;
        LoadCommandsReader loadCommandsReader = new LoadCommandsReader(commandOffset, commandNum, accessFile, commandSize);
        LoadCommand loadCommand = loadCommandsReader.read();
        loadCommand.useBytesCount = commandSize;
        bytesCount += loadCommand.useBytesCount;
        return loadCommand;
    }


}
