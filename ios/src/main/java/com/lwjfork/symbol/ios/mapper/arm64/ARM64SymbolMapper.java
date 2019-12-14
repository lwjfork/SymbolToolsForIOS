package com.lwjfork.symbol.ios.mapper.arm64;

import com.lwjfork.symbol.ios.model.arm64.ARM64Symbol;
import com.lwjfork.symbol.ios.vo.arm64.ARM64SymbolBytes;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {ARM64LcMapper.class, ARM64MachHeaderMapper.class})
public interface ARM64SymbolMapper {

    ARM64SymbolMapper INSTANCE = Mappers.getMapper(ARM64SymbolMapper.class);

    ARM64Symbol bytes2Model(ARM64SymbolBytes bytes);


}
