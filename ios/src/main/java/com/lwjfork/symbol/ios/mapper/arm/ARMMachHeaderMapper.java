package com.lwjfork.symbol.ios.mapper.arm;

import com.lwjfork.symbol.ios.model.arm.mach_header.ARMMachHeader;
import com.lwjfork.symbol.ios.vo.arm.mach_header.ARMMachHeaderBytes;
import com.lwjfork.symbol.tools.mapper.Bytes2LongMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper(uses = Bytes2LongMapper.class)
public interface ARMMachHeaderMapper {


    ARMMachHeaderMapper INSTANCE = Mappers.getMapper(ARMMachHeaderMapper.class);


    ARMMachHeader bytes2Model(ARMMachHeaderBytes bytes);


}
