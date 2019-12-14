package com.lwjfork.symbol.ios.reader.common.command;

import com.lwjfork.symbol.ios.mapper.common.SectionMapper;
import com.lwjfork.symbol.ios.model.common.section.SectionContent;
import com.lwjfork.symbol.ios.reader.common.base.BaseAssignBytesCountReader;
import com.lwjfork.symbol.ios.vo.common.command.BaseSectionHeaderBytes;
import com.lwjfork.symbol.ios.vo.common.section.SectionContentBytes;

import java.io.IOException;
import java.io.RandomAccessFile;

public class SectionContentReader extends BaseAssignBytesCountReader<SectionContent, SectionContentBytes> {

    BaseSectionHeaderBytes sectionHeaderBytes;


    public SectionContentReader(long offset, RandomAccessFile accessFile, long maxBytesCount, BaseSectionHeaderBytes sectionHeaderBytes) {
        super(offset, accessFile, maxBytesCount);
        this.sectionHeaderBytes = sectionHeaderBytes;
    }


    @Override
    protected SectionContent convertBytes2Model(SectionContentBytes bytes) {
        return SectionMapper.INSTANCE.bytes2Model(bytes);
    }

    @Override
    protected SectionContentBytes readBytes() throws IOException {
        accessFile.seek(offset);
        SectionContentBytes bytesCountBytes = new SectionContentBytes();
        bytesCountBytes.content = readAssignCountBytes((int) maxBytesCount);
        bytesCountBytes.sectionName = sectionHeaderBytes.sectionName;
        bytesCountBytes.segmentName = sectionHeaderBytes.segmentName;
        return bytesCountBytes;
    }

    @Override
    protected void writeOffsetAndBytesCount(SectionContentBytes bytes) {
        bytes.offsetHexStrOfBytes = getOffsetHexStr();
        bytes.offsetOfBytes = getOffset();
        bytes.useBytesCount = maxBytesCount;
    }
}
