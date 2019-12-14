package com.lwjfork.symbol.ios.mapper.arm64;

import com.lwjfork.symbol.ios.model.arm64.ARM64Symbol;
import com.lwjfork.symbol.ios.vo.arm64.ARM64SymbolBytes;
import javax.annotation.Generated;
import org.mapstruct.factory.Mappers;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-12-14T15:24:28+0800",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_221 (Oracle Corporation)"
)
public class ARM64SymbolMapperImpl implements ARM64SymbolMapper {

    private final ARM64LcMapper aRM64LcMapper = Mappers.getMapper( ARM64LcMapper.class );
    private final ARM64MachHeaderMapper aRM64MachHeaderMapper = Mappers.getMapper( ARM64MachHeaderMapper.class );

    @Override
    public ARM64Symbol bytes2Model(ARM64SymbolBytes bytes) {
        if ( bytes == null ) {
            return null;
        }

        ARM64Symbol aRM64Symbol = new ARM64Symbol();

        aRM64Symbol.useBytesCount = bytes.useBytesCount;
        aRM64Symbol.offset = bytes.offset;
        aRM64Symbol.machHeader = aRM64MachHeaderMapper.bytes2Model( bytes.machHeader );
        aRM64Symbol.lc = aRM64LcMapper.bytes2Model( bytes.lc );

        return aRM64Symbol;
    }
}
