package com.lwjfork.symbol.ios.mapper.arm64;

import com.lwjfork.symbol.ios.mapper.common.BaseLcMapper;
import com.lwjfork.symbol.ios.mapper.common.SectionOrSegmentNamMapper;
import com.lwjfork.symbol.ios.model.arm64.command.ARM64Lc;
import com.lwjfork.symbol.ios.model.arm64.command.ARM64LcSectionHeader;
import com.lwjfork.symbol.ios.model.arm64.command.ARM64LcSegment;
import com.lwjfork.symbol.ios.vo.arm64.command.ARM64LcBytes;
import com.lwjfork.symbol.ios.vo.arm64.command.ARM64LcSectionHeaderBytes;
import com.lwjfork.symbol.ios.vo.arm64.command.ARM64LcSegmentBytes;
import com.lwjfork.symbol.tools.mapper.Bytes2BigIntegerMapper;
import com.lwjfork.symbol.tools.mapper.Bytes2LongMapper;
import com.lwjfork.symbol.tools.mapper.BytesAsciiStr2StrMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper(uses = {
        Bytes2LongMapper.class,
        BytesAsciiStr2StrMapper.class,
        Bytes2BigIntegerMapper.class,
        BaseLcMapper.class})
public interface ARM64LcMapper {


    ARM64LcMapper INSTANCE = Mappers.getMapper(ARM64LcMapper.class);


    ARM64Lc bytes2Model(ARM64LcBytes bytes);

    @Mapping(source = "segmentName", target = "segmentName", qualifiedByName = {SectionOrSegmentNamMapper.SectionOrSegmentNamMapper, SectionOrSegmentNamMapper.convertName})
    ARM64LcSegment bytes2Model(ARM64LcSegmentBytes bytes);


    @Mapping(source = "segmentName", target = "segmentName", qualifiedByName = {SectionOrSegmentNamMapper.SectionOrSegmentNamMapper, SectionOrSegmentNamMapper.convertName})
    @Mapping(source = "sectionName", target = "sectionName", qualifiedByName = {SectionOrSegmentNamMapper.SectionOrSegmentNamMapper, SectionOrSegmentNamMapper.convertName})
    ARM64LcSectionHeader bytes2Model(ARM64LcSectionHeaderBytes bytes);


}
