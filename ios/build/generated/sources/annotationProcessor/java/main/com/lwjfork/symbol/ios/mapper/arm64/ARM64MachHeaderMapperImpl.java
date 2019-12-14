package com.lwjfork.symbol.ios.mapper.arm64;

import com.lwjfork.symbol.ios.model.arm64.mach_header.ARM64MachHeader;
import com.lwjfork.symbol.ios.vo.arm64.mach_header.ARM64MachHeaderBytes;
import com.lwjfork.symbol.tools.mapper.Bytes2LongMapper;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-12-14T15:24:28+0800",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_221 (Oracle Corporation)"
)
public class ARM64MachHeaderMapperImpl implements ARM64MachHeaderMapper {

    private final Bytes2LongMapper bytes2LongMapper = new Bytes2LongMapper();

    @Override
    public ARM64MachHeader bytes2Model(ARM64MachHeaderBytes bytes) {
        if ( bytes == null ) {
            return null;
        }

        ARM64MachHeader aRM64MachHeader = new ARM64MachHeader();

        aRM64MachHeader.useBytesCount = bytes.useBytesCount;
        aRM64MachHeader.offset = bytes.offset;
        aRM64MachHeader.magicNum = bytes2LongMapper.byte4ToLong( bytes.magicNum );
        aRM64MachHeader.cpuType = bytes2LongMapper.byte4ToLong( bytes.cpuType );
        aRM64MachHeader.cpuSubType = bytes2LongMapper.byte4ToLong( bytes.cpuSubType );
        aRM64MachHeader.fileType = bytes2LongMapper.byte4ToLong( bytes.fileType );
        aRM64MachHeader.commandsNum = bytes2LongMapper.byte4ToLong( bytes.commandsNum );
        aRM64MachHeader.commandSize = bytes2LongMapper.byte4ToLong( bytes.commandSize );
        aRM64MachHeader.flags = bytes2LongMapper.byte4ToLong( bytes.flags );
        aRM64MachHeader.reserved = bytes2LongMapper.byte4ToLong( bytes.reserved );

        return aRM64MachHeader;
    }
}
