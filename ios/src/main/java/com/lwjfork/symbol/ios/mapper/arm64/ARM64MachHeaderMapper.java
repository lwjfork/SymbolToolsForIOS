package com.lwjfork.symbol.ios.mapper.arm64;

import com.lwjfork.symbol.ios.model.arm64.mach_header.ARM64MachHeader;
import com.lwjfork.symbol.ios.vo.arm64.mach_header.ARM64MachHeaderBytes;
import com.lwjfork.symbol.tools.mapper.Bytes2LongMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper(uses = Bytes2LongMapper.class)
public interface ARM64MachHeaderMapper  {

    ARM64MachHeaderMapper INSTANCE = Mappers.getMapper(ARM64MachHeaderMapper.class);


    ARM64MachHeader bytes2Model(ARM64MachHeaderBytes bytes);


}
