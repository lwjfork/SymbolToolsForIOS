package com.lwjfork.symbol.ios.mapper.common;

import com.lwjfork.symbol.ios.mapper.arm64.UUIDMapper;
import com.lwjfork.symbol.ios.model.common.command.LcSymTab;
import com.lwjfork.symbol.ios.model.common.command.LcUuid;
import com.lwjfork.symbol.ios.vo.common.command.LcSymTabBytes;
import com.lwjfork.symbol.ios.vo.common.command.LcUuidBytes;
import com.lwjfork.symbol.tools.mapper.Bytes2LongMapper;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-12-14T15:24:27+0800",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_221 (Oracle Corporation)"
)
public class BaseLcMapperImpl implements BaseLcMapper {

    private final Bytes2LongMapper bytes2LongMapper = new Bytes2LongMapper();
    private final UUIDMapper uUIDMapper = new UUIDMapper();

    @Override
    public LcUuid bytes2Model(LcUuidBytes bytes) {
        if ( bytes == null ) {
            return null;
        }

        LcUuid lcUuid = new LcUuid();

        lcUuid.uuid = uUIDMapper.convertUUID( bytes.uuid );
        lcUuid.useBytesCount = bytes.useBytesCount;
        lcUuid.offset = bytes.offset;
        lcUuid.command = bytes2LongMapper.byte4ToLong( bytes.command );
        lcUuid.commandSize = bytes2LongMapper.byte4ToLong( bytes.commandSize );

        return lcUuid;
    }

    @Override
    public LcSymTab bytes2Model(LcSymTabBytes bytes) {
        if ( bytes == null ) {
            return null;
        }

        LcSymTab lcSymTab = new LcSymTab();

        lcSymTab.useBytesCount = bytes.useBytesCount;
        lcSymTab.offset = bytes.offset;
        lcSymTab.command = bytes2LongMapper.byte4ToLong( bytes.command );
        lcSymTab.commandSize = bytes2LongMapper.byte4ToLong( bytes.commandSize );
        lcSymTab.symbolTableOffset = bytes2LongMapper.byte4ToLong( bytes.symbolTableOffset );
        lcSymTab.symbolTableNum = bytes2LongMapper.byte4ToLong( bytes.symbolTableNum );
        lcSymTab.stringTableOffset = bytes2LongMapper.byte4ToLong( bytes.stringTableOffset );
        lcSymTab.stringTableSize = bytes2LongMapper.byte4ToLong( bytes.stringTableSize );

        return lcSymTab;
    }
}
