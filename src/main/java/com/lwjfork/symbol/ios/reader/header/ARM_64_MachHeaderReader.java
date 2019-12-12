package com.lwjfork.symbol.ios.reader.header;

import com.lwjfork.symbol.ios.model.header.ARM_64_MachHeader;
import com.lwjfork.symbol.ios.reader.base.BaseMachHeaderReader;

import java.io.IOException;
import java.io.RandomAccessFile;

public class ARM_64_MachHeaderReader extends BaseMachHeaderReader<ARM_64_MachHeader> {


    public ARM_64_MachHeaderReader(RandomAccessFile accessFile) {
        super(0, accessFile);
    }

    public ARM_64_MachHeaderReader(long offset, RandomAccessFile accessFile) {
        super(offset, accessFile);
    }

    @Override
    public ARM_64_MachHeader read() throws IOException {
        accessFile.seek(offset);
        ARM_64_MachHeader machHeader = new ARM_64_MachHeader();
        readBaseHeader(machHeader);
        machHeader.reserved = read4Bytes2Long(true);
        machHeader.useBytesCount = bytesCount;
        return machHeader;
    }

}
