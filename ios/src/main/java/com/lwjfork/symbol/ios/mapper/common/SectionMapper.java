package com.lwjfork.symbol.ios.mapper.common;

import com.lwjfork.symbol.ios.model.common.section.SectionContent;
import com.lwjfork.symbol.ios.vo.common.section.SectionContentBytes;
import com.lwjfork.symbol.tools.mapper.BytesAsciiStr2StrMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(uses = {
        SectionOrSegmentNamMapper.class,
        BytesAsciiStr2StrMapper.class,
        BytesCountMapper.class})
public interface SectionMapper {


    SectionMapper INSTANCE  = Mappers.getMapper(SectionMapper.class);

    @Mapping(source = "segmentName", target = "segmentName", qualifiedByName = {SectionOrSegmentNamMapper.SectionOrSegmentNamMapper, SectionOrSegmentNamMapper.convertName})
    @Mapping(source = "sectionName", target = "sectionName", qualifiedByName = {SectionOrSegmentNamMapper.SectionOrSegmentNamMapper, SectionOrSegmentNamMapper.convertName})
    SectionContent bytes2Model(SectionContentBytes bytes);

    List<SectionContent> bytes2Model(List<SectionContentBytes> bytes);
}
