package com.lwjfork.symbol.ios.reader.command;

import com.lwjfork.symbol.ios.constant.LoadCommandType;
import com.lwjfork.symbol.ios.model.command.LoadCommand;
import com.lwjfork.symbol.ios.reader.base.BaseAssignBytesCountReader;

import java.io.IOException;
import java.io.RandomAccessFile;

public class LoadCommandsReader extends BaseAssignBytesCountReader<LoadCommand> {

    long commandsNum;

    public LoadCommandsReader(long offset, long commandsNum, RandomAccessFile accessFile, long maxBytesCount) {
        super(offset, accessFile, maxBytesCount);
        this.commandsNum = commandsNum;
    }

    @Override
    public LoadCommand read() throws IOException {
        LoadCommand loadCommand = new LoadCommand();
        long commandOffset = offset;
        for (long i = 0; i < commandsNum; i++) {
            accessFile.seek(commandOffset);
            long commandType = read4Bytes2Long(true);
            long commandSize = read4Bytes2Long(true);
            bytesCount = bytesCount + commandSize;
            if (commandType == LoadCommandType.UUID) { // UUID
                LoadCommandUUIDReader commandUUIDReader = new LoadCommandUUIDReader(commandOffset, accessFile, commandSize);
                loadCommand.lcUUID = commandUUIDReader.read();
                System.out.println(loadCommand.lcUUID.toString());
            } else if (commandType == LoadCommandType.SYM_TAB) {
                LoadCommandSymTabReader symTabReader = new LoadCommandSymTabReader(commandOffset, accessFile, commandSize);
                loadCommand.lcSymTab = symTabReader.read();
                System.out.println(loadCommand.lcSymTab.toString());
            } else if (commandType == LoadCommandType.SEGMENT) {

            }
            commandOffset = commandOffset + commandSize;
        }
        return loadCommand;
    }
}
