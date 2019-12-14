package com.lwjfork.symbol.ios.mapper.common;

import com.lwjfork.symbol.ios.model.common.base.BytesCountStr;
import com.lwjfork.symbol.ios.vo.common.base.BytesCountBytes;
import com.lwjfork.symbol.tools.mapper.BytesAsciiStr2StrMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper(uses = {
        BytesAsciiStr2StrMapper.class
})
public interface BytesCountMapper {

     BytesCountMapper INSTANCE = Mappers.getMapper(BytesCountMapper.class);

     BytesCountStr convertStr(BytesCountBytes bytesCountBytes);
}
