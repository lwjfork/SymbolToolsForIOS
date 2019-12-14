package com.lwjfork.symbol.ios.mapper.arm;

import com.lwjfork.symbol.ios.mapper.common.BaseLcMapper;
import com.lwjfork.symbol.ios.mapper.common.PowerMapper;
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

import java.util.List;

@Mapper(uses = {
        Bytes2LongMapper.class,
        BytesAsciiStr2StrMapper.class,
        PowerMapper.class,
        BaseLcMapper.class})
public interface ARMLcMapper {

    ARMLcMapper INSTANCE = Mappers.getMapper(ARMLcMapper.class);


    ARMLc bytes2Model(ARMLcBytes bytes);


    @Mapping(source = "segmentName", target = "segmentName", qualifiedByName = {SectionOrSegmentNamMapper.SectionOrSegmentNamMapper, SectionOrSegmentNamMapper.convertName})
    ARMLcSegment bytes2ModelSegment(ARMLcSegmentBytes bytes);


    @Mapping(source = "segmentName", target = "segmentName", qualifiedByName = {SectionOrSegmentNamMapper.SectionOrSegmentNamMapper, SectionOrSegmentNamMapper.convertName})
    @Mapping(source = "sectionName", target = "sectionName", qualifiedByName = {SectionOrSegmentNamMapper.SectionOrSegmentNamMapper, SectionOrSegmentNamMapper.convertName})
    @Mapping(source = "alignment", target = "alignment", qualifiedByName = {PowerMapper.PowerMapper, PowerMapper.byte4ToPower})
    ARMLcSectionHeader bytes2SectionHeader(ARMLcSectionHeaderBytes bytes);

    List<ARMLcSectionHeader> bytes2SectionHeader(List<ARMLcSectionHeaderBytes> bytes);

    List<ARMLcSegment> bytes2ModelSegment(List<ARMLcSegmentBytes> bytes);


}
