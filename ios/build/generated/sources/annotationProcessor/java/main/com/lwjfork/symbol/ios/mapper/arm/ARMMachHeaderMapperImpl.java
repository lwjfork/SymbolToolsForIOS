package com.lwjfork.symbol.ios.mapper.arm;

import com.lwjfork.symbol.ios.model.arm.mach_header.ARMMachHeader;
import com.lwjfork.symbol.ios.vo.arm.mach_header.ARMMachHeaderBytes;
import com.lwjfork.symbol.tools.mapper.Bytes2LongMapper;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-12-14T15:24:28+0800",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_221 (Oracle Corporation)"
)
public class ARMMachHeaderMapperImpl implements ARMMachHeaderMapper {

    private final Bytes2LongMapper bytes2LongMapper = new Bytes2LongMapper();

    @Override
    public ARMMachHeader bytes2Model(ARMMachHeaderBytes bytes) {
        if ( bytes == null ) {
            return null;
        }

        ARMMachHeader aRMMachHeader = new ARMMachHeader();

        aRMMachHeader.useBytesCount = bytes.useBytesCount;
        aRMMachHeader.offset = bytes.offset;
        aRMMachHeader.magicNum = bytes2LongMapper.byte4ToLong( bytes.magicNum );
        aRMMachHeader.cpuType = bytes2LongMapper.byte4ToLong( bytes.cpuType );
        aRMMachHeader.cpuSubType = bytes2LongMapper.byte4ToLong( bytes.cpuSubType );
        aRMMachHeader.fileType = bytes2LongMapper.byte4ToLong( bytes.fileType );
        aRMMachHeader.commandsNum = bytes2LongMapper.byte4ToLong( bytes.commandsNum );
        aRMMachHeader.commandSize = bytes2LongMapper.byte4ToLong( bytes.commandSize );
        aRMMachHeader.flags = bytes2LongMapper.byte4ToLong( bytes.flags );

        return aRMMachHeader;
    }
}
