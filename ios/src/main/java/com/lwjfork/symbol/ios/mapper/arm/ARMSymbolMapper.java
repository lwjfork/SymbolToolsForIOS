package com.lwjfork.symbol.ios.mapper.arm;

import com.lwjfork.symbol.ios.model.arm.ARMSymbol;
import com.lwjfork.symbol.ios.vo.arm.ARMSymbolBytes;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {ARMLcMapper.class, ARMMachHeaderMapper.class})
public interface ARMSymbolMapper {


    ARMSymbolMapper INSTANCE = Mappers.getMapper(ARMSymbolMapper.class);

    ARMSymbol bytes2Model(ARMSymbolBytes bytes);


}
