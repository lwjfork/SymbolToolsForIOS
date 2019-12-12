package com.lwjfork.symbol.ios.reader.header;

import com.lwjfork.symbol.ios.constant.MagicNumberType;
import com.lwjfork.symbol.ios.model.base.BaseMachHeader;
import com.lwjfork.symbol.ios.model.header.ARM_64_MachHeader;
import com.lwjfork.symbol.ios.model.header.ARM_V7_MachHeader;
import com.lwjfork.symbol.ios.model.header.FatArchHeader;
import com.lwjfork.symbol.ios.reader.base.BaseReader;

import java.io.IOException;
import java.io.RandomAccessFile;

public class MachHeaderReader extends BaseReader<BaseMachHeader> {

    public MachHeaderReader(FatArchHeader fatArchHeader, RandomAccessFile accessFile) {
        super(fatArchHeader.symbolsOffset, accessFile);
    }

    public MachHeaderReader(RandomAccessFile accessFile) {
        super(0, accessFile);
    }


    @Override
    public BaseMachHeader read() throws IOException {
        accessFile.seek(offset);
        long magicNumber = read4Bytes2Long();
        if (magicNumber == MagicNumberType.MH64_MAGIC_NUMBER) {
            ARM_64_MachHeaderReader machHeaderReader = new ARM_64_MachHeaderReader(offset, accessFile);
            ARM_64_MachHeader baseMachHeader = machHeaderReader.read();
            currentIndex = machHeaderReader.getCurrentIndex();
            bytesCount = baseMachHeader.useBytesCount;
            return baseMachHeader;
        } else if (magicNumber == MagicNumberType.MH_MAGIC_NUMBER) {
            ARM_V7_MachHeaderReader machHeaderReader = new ARM_V7_MachHeaderReader(offset, accessFile);
            ARM_V7_MachHeader baseMachHeader = machHeaderReader.read();
            currentIndex = machHeaderReader.getCurrentIndex();
            bytesCount = baseMachHeader.useBytesCount;
            return baseMachHeader;
        }
        return null;
    }
}
