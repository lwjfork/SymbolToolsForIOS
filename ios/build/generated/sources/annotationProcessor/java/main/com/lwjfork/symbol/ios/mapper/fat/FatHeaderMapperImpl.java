package com.lwjfork.symbol.ios.mapper.fat;

import com.lwjfork.symbol.ios.model.common.header.FatArchHeader;
import com.lwjfork.symbol.ios.model.common.header.FatHeader;
import com.lwjfork.symbol.ios.vo.common.fat.FatArchHeaderBytes;
import com.lwjfork.symbol.ios.vo.common.fat.FatHeaderBytes;
import com.lwjfork.symbol.tools.mapper.Bytes2LongMapper;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-12-14T15:24:28+0800",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_221 (Oracle Corporation)"
)
public class FatHeaderMapperImpl implements FatHeaderMapper {

    private final Bytes2LongMapper bytes2LongMapper = new Bytes2LongMapper();

    @Override
    public FatHeader bytes2Model(FatHeaderBytes bytes) {
        if ( bytes == null ) {
            return null;
        }

        FatHeader fatHeader = new FatHeader();

        fatHeader.useBytesCount = bytes.useBytesCount;
        fatHeader.offset = bytes.offset;
        fatHeader.magicNum = bytes2LongMapper.byte4ToLong( bytes.magicNum );
        fatHeader.archNum = bytes2LongMapper.byte4ToLong( bytes.archNum );
        fatHeader.arches = fatArchHeaderBytesListToFatArchHeaderList( bytes.arches );

        return fatHeader;
    }

    @Override
    public FatArchHeader bytes2Model(FatArchHeaderBytes bytes) {
        if ( bytes == null ) {
            return null;
        }

        FatArchHeader fatArchHeader = new FatArchHeader();

        fatArchHeader.useBytesCount = bytes.useBytesCount;
        fatArchHeader.offset = bytes.offset;
        fatArchHeader.cpuType = bytes2LongMapper.byte4ToLong( bytes.cpuType );
        fatArchHeader.cpuSubType = bytes2LongMapper.byte4ToLong( bytes.cpuSubType );
        fatArchHeader.symbolsOffset = bytes2LongMapper.byte4ToLong( bytes.symbolsOffset );
        fatArchHeader.symbolsSize = bytes2LongMapper.byte4ToLong( bytes.symbolsSize );
        fatArchHeader.symbolsAlign = bytes2LongMapper.byte4ToLong( bytes.symbolsAlign );

        return fatArchHeader;
    }

    protected List<FatArchHeader> fatArchHeaderBytesListToFatArchHeaderList(List<FatArchHeaderBytes> list) {
        if ( list == null ) {
            return null;
        }

        List<FatArchHeader> list1 = new ArrayList<FatArchHeader>( list.size() );
        for ( FatArchHeaderBytes fatArchHeaderBytes : list ) {
            list1.add( bytes2Model( fatArchHeaderBytes ) );
        }

        return list1;
    }
}
