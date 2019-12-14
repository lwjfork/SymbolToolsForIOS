package com.lwjfork.symbol.ios.mapper.fat;

import com.lwjfork.symbol.ios.model.common.header.FatArchHeader;
import com.lwjfork.symbol.ios.model.common.header.FatHeader;
import com.lwjfork.symbol.ios.vo.common.fat.FatArchHeaderBytes;
import com.lwjfork.symbol.ios.vo.common.fat.FatHeaderBytes;
import com.lwjfork.symbol.tools.mapper.Bytes2LongMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {Bytes2LongMapper.class})
public interface FatHeaderMapper {

    FatHeaderMapper INSTANCE = Mappers.getMapper(FatHeaderMapper.class);


    FatHeader bytes2Model(FatHeaderBytes bytes);

    FatArchHeader bytes2Model(FatArchHeaderBytes bytes);

}
