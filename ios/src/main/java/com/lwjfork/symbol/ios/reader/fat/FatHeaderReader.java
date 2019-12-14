package com.lwjfork.symbol.ios.reader.fat;

import com.lwjfork.symbol.ios.mapper.fat.FatHeaderMapper;
import com.lwjfork.symbol.ios.model.common.header.FatHeader;
import com.lwjfork.symbol.ios.reader.common.base.BaseReader;
import com.lwjfork.symbol.ios.vo.common.fat.FatArchHeaderBytes;
import com.lwjfork.symbol.ios.vo.common.fat.FatHeaderBytes;
import com.lwjfork.symbol.tools.mapper.Bytes2LongMapper;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 读取 Fat header 信息
 */
public class FatHeaderReader extends BaseReader<FatHeader, FatHeaderBytes> {


    FatHeaderMapper mapper = FatHeaderMapper.INSTANCE;
    Bytes2LongMapper byte4ToLongMapper = Bytes2LongMapper.INSTANCE;


    public FatHeaderReader(RandomAccessFile accessFile) {
        super(0, accessFile);
    }

    @Override
    protected void writeOffsetAndBytesCount(FatHeaderBytes bytes) {
        bytes.offsetHexStrOfBytes = bytes.magicNum.offsetHexStrOfBytes;
        bytes.offsetOfBytes = bytes.magicNum.offsetOfBytes;
        bytes.useBytesCount = bytesCount;
    }

    @Override
    protected FatHeader convertBytes2Model(FatHeaderBytes bytes) {

        return mapper.bytes2Model(bytes);
    }

    @Override
    protected FatHeaderBytes readBytes() throws IOException {
        accessFile.seek(getStartReadIndex());
        FatHeaderBytes fatHeaderBytes = new FatHeaderBytes();
        fatHeaderBytes.magicNum = read4Bytes();
        fatHeaderBytes.archNum = read4Bytes();
        long archHeaderOffset = fatHeaderBytes.magicNum.getBytesCount() + fatHeaderBytes.archNum.getBytesCount();
        long archNum = byte4ToLongMapper.byte4ToLong(fatHeaderBytes.archNum);
        for (long i = 0; i < archNum; i++) {
            FatArchHeaderReader fatArchHeaderReader = new FatArchHeaderReader(archHeaderOffset, accessFile);
            FatArchHeaderBytes fatArchHeaderBytes = fatArchHeaderReader.readBytesFinal();
            fatHeaderBytes.arches.add(fatArchHeaderBytes);
            bytesCount = bytesCount + fatArchHeaderBytes.useBytesCount;
            archHeaderOffset = fatArchHeaderBytes.useBytesCount + archHeaderOffset;
        }
        return fatHeaderBytes;
    }


}
