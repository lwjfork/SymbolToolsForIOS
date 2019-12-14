package com.lwjfork.symbol.ios.mapper.arm;

import com.lwjfork.symbol.ios.model.arm.ARMSymbol;
import com.lwjfork.symbol.ios.vo.arm.ARMSymbolBytes;
import javax.annotation.Generated;
import org.mapstruct.factory.Mappers;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-12-14T15:24:28+0800",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_221 (Oracle Corporation)"
)
public class ARMSymbolMapperImpl implements ARMSymbolMapper {

    private final ARMLcMapper aRMLcMapper = Mappers.getMapper( ARMLcMapper.class );
    private final ARMMachHeaderMapper aRMMachHeaderMapper = Mappers.getMapper( ARMMachHeaderMapper.class );

    @Override
    public ARMSymbol bytes2Model(ARMSymbolBytes bytes) {
        if ( bytes == null ) {
            return null;
        }

        ARMSymbol aRMSymbol = new ARMSymbol();

        aRMSymbol.useBytesCount = bytes.useBytesCount;
        aRMSymbol.offset = bytes.offset;
        aRMSymbol.machHeader = aRMMachHeaderMapper.bytes2Model( bytes.machHeader );
        aRMSymbol.lc = aRMLcMapper.bytes2Model( bytes.lc );

        return aRMSymbol;
    }
}
