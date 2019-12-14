package com.lwjfork.symbol.ios.mapper.common;

import com.lwjfork.symbol.ios.model.common.command.LcSymTab;
import com.lwjfork.symbol.ios.model.common.command.LcUuid;
import com.lwjfork.symbol.ios.vo.common.command.LcSymTabBytes;
import com.lwjfork.symbol.ios.vo.common.command.LcUuidBytes;
import com.lwjfork.symbol.tools.mapper.Bytes2LongMapper;
import com.lwjfork.symbol.tools.mapper.BytesAsciiStr2StrMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {
        Bytes2LongMapper.class,
        BytesAsciiStr2StrMapper.class,
        UUIDMapper.class,
})
public interface BaseLcMapper {

    BaseLcMapper INSTANCE = Mappers.getMapper(BaseLcMapper.class);

    @Mapping(source = "uuid", target = "uuid", qualifiedByName = {UUIDMapper.UUIDMapper, UUIDMapper.CONVERT_UUID})
    LcUuid bytes2Model(LcUuidBytes bytes);

    LcSymTab bytes2Model(LcSymTabBytes bytes);

}
