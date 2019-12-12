package com.lwjfork.symbol.ios.reader.symbol;

import com.lwjfork.symbol.ios.model.header.ARM_64_MachHeader;
import com.lwjfork.symbol.ios.model.symbol.ARM_64_Symbol;
import com.lwjfork.symbol.ios.reader.base.BaseSymbolsReader;

import java.io.IOException;
import java.io.RandomAccessFile;

public class ARM_V64_SymbolReader extends BaseSymbolsReader<ARM_64_MachHeader, ARM_64_Symbol> {

    public ARM_V64_SymbolReader(ARM_64_MachHeader header, long offset, RandomAccessFile accessFile, long maxBytesCount) {
        super(header, offset, accessFile, maxBytesCount);
    }

    @Override
    protected ARM_64_MachHeader readMachHeader() throws IOException {
        return header;
    }

    @Override
    public ARM_64_Symbol read() throws IOException {
        long contentOffset = getStartReadIndex() + header.useBytesCount;
        accessFile.seek(contentOffset);
        ARM_64_Symbol symbol = new ARM_64_Symbol();
        symbol.machHeader = header;
        symbol.command = readLoadCommand();
        return symbol;
    }

}