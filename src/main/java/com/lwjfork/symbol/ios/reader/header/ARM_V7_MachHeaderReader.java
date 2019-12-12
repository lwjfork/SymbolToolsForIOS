package com.lwjfork.symbol.ios.reader.header;

import com.lwjfork.symbol.ios.model.header.ARM_V7_MachHeader;
import com.lwjfork.symbol.ios.reader.base.BaseMachHeaderReader;

import java.io.IOException;
import java.io.RandomAccessFile;

public class ARM_V7_MachHeaderReader extends BaseMachHeaderReader<ARM_V7_MachHeader> {

    public ARM_V7_MachHeaderReader(RandomAccessFile accessFile) {
        super(0, accessFile);
    }

    public ARM_V7_MachHeaderReader(long offset, RandomAccessFile accessFile) {
        super(offset, accessFile);
    }

    @Override
    public ARM_V7_MachHeader read() throws IOException {
        accessFile.seek(offset);
        ARM_V7_MachHeader arm_v7_machHeader = new ARM_V7_MachHeader();
        readBaseHeader(arm_v7_machHeader);
        arm_v7_machHeader.useBytesCount = bytesCount;
        return arm_v7_machHeader;
    }
}

