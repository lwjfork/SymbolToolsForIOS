package com.lwjfork.symbol.ios.mapper.arm;

import com.lwjfork.symbol.ios.mapper.common.BytesCountMapper;
import com.lwjfork.symbol.ios.mapper.common.SectionMapper;
import com.lwjfork.symbol.ios.mapper.common.SectionOrSegmentNamMapper;
import com.lwjfork.symbol.ios.model.arm.ARMSymbol;
import com.lwjfork.symbol.ios.vo.arm.ARMSymbolBytes;
import com.lwjfork.symbol.tools.mapper.Bytes2LongMapper;
import com.lwjfork.symbol.tools.mapper.BytesAsciiStr2StrMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {
        ARMLcMapper.class,
        ARMMachHeaderMapper.class,
        SectionOrSegmentNamMapper.class,
        BytesAsciiStr2StrMapper.class,
        Bytes2LongMapper.class,
        SectionMapper.class,
        BytesCountMapper.class})
public interface ARMSymbolMapper {


    ARMSymbolMapper INSTANCE = Mappers.getMapper(ARMSymbolMapper.class);

    ARMSymbol bytes2Model(ARMSymbolBytes bytes);

}
