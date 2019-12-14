package com.lwjfork.symbol.ios.mapper.arm;

import com.lwjfork.symbol.ios.mapper.common.BaseLcMapper;
import com.lwjfork.symbol.ios.mapper.common.SectionOrSegmentNamMapper;
import com.lwjfork.symbol.ios.model.arm.command.ARMLc;
import com.lwjfork.symbol.ios.model.arm.command.ARMLcSectionHeader;
import com.lwjfork.symbol.ios.model.arm.command.ARMLcSegment;
import com.lwjfork.symbol.ios.vo.arm.command.ARMLcBytes;
import com.lwjfork.symbol.ios.vo.arm.command.ARMLcSectionHeaderBytes;
import com.lwjfork.symbol.ios.vo.arm.command.ARMLcSegmentBytes;
import com.lwjfork.symbol.tools.mapper.Bytes2LongMapper;
import com.lwjfork.symbol.tools.mapper.BytesAsciiStr2StrMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {
        Bytes2LongMapper.class,
        BytesAsciiStr2StrMapper.class,
        BaseLcMapper.class})
public interface ARMLcMapper {

    ARMLcMapper INSTANCE = Mappers.getMapper(ARMLcMapper.class);


    ARMLc bytes2Model(ARMLcBytes bytes);


    @Mapping(source = "segmentName", target = "segmentName", qualifiedByName = {SectionOrSegmentNamMapper.SectionOrSegmentNamMapper, SectionOrSegmentNamMapper.convertName})
    ARMLcSegment bytes2Model(ARMLcSegmentBytes bytes);


    @Mapping(source = "segmentName", target = "segmentName", qualifiedByName = {SectionOrSegmentNamMapper.SectionOrSegmentNamMapper, SectionOrSegmentNamMapper.convertName})
    @Mapping(source = "sectionName", target = "sectionName", qualifiedByName = {SectionOrSegmentNamMapper.SectionOrSegmentNamMapper, SectionOrSegmentNamMapper.convertName})
    ARMLcSectionHeader bytes2Model(ARMLcSectionHeaderBytes bytes);


}
