package com.lwjfork.symbol.ios.mapper.arm64;

import com.lwjfork.symbol.ios.mapper.common.BaseLcMapper;
import com.lwjfork.symbol.ios.model.arm64.command.ARM64Lc;
import com.lwjfork.symbol.ios.model.arm64.command.ARM64LcSegment;
import com.lwjfork.symbol.ios.vo.arm64.command.ARM64LcBytes;
import com.lwjfork.symbol.ios.vo.arm64.command.ARM64LcSegmentBytes;
import com.lwjfork.symbol.tools.mapper.Bytes2LongMapper;
import com.lwjfork.symbol.tools.mapper.BytesAsciiStr2StrMapper;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.mapstruct.factory.Mappers;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-12-14T15:24:28+0800",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_221 (Oracle Corporation)"
)
public class ARM64LcMapperImpl implements ARM64LcMapper {

    private final Bytes2LongMapper bytes2LongMapper = new Bytes2LongMapper();
    private final BytesAsciiStr2StrMapper bytesAsciiStr2StrMapper = new BytesAsciiStr2StrMapper();
    private final BaseLcMapper baseLcMapper = Mappers.getMapper( BaseLcMapper.class );

    @Override
    public ARM64Lc bytes2Model(ARM64LcBytes bytes) {
        if ( bytes == null ) {
            return null;
        }

        ARM64Lc aRM64Lc = new ARM64Lc();

        aRM64Lc.useBytesCount = bytes.useBytesCount;
        aRM64Lc.offset = bytes.offset;
        aRM64Lc.lcUUID = baseLcMapper.bytes2Model( bytes.lcUUID );
        aRM64Lc.lcSymTab = baseLcMapper.bytes2Model( bytes.lcSymTab );
        aRM64Lc.segments = aRM64LcSegmentBytesListToARM64LcSegmentList( bytes.segments );

        return aRM64Lc;
    }

    @Override
    public ARM64LcSegment bytes2Model(ARM64LcSegmentBytes bytes) {
        if ( bytes == null ) {
            return null;
        }

        ARM64LcSegment aRM64LcSegment = new ARM64LcSegment();

        aRM64LcSegment.useBytesCount = bytes.useBytesCount;
        aRM64LcSegment.offset = bytes.offset;
        aRM64LcSegment.command = bytes2LongMapper.byte4ToLong( bytes.command );
        aRM64LcSegment.commandSize = bytes2LongMapper.byte4ToLong( bytes.commandSize );
        aRM64LcSegment.segmentName = bytesAsciiStr2StrMapper.byte16AsciiToStr( bytes.segmentName );
        if ( bytes.VMAddress != null ) {
            aRM64LcSegment.VMAddress = BigInteger.valueOf( bytes2LongMapper.byte8ToLong( bytes.VMAddress ) );
        }
        if ( bytes.VMSize != null ) {
            aRM64LcSegment.VMSize = BigInteger.valueOf( bytes2LongMapper.byte8ToLong( bytes.VMSize ) );
        }
        if ( bytes.fileOffset != null ) {
            aRM64LcSegment.fileOffset = BigInteger.valueOf( bytes2LongMapper.byte8ToLong( bytes.fileOffset ) );
        }
        if ( bytes.fileSize != null ) {
            aRM64LcSegment.fileSize = BigInteger.valueOf( bytes2LongMapper.byte8ToLong( bytes.fileSize ) );
        }
        aRM64LcSegment.maxVMProtection = bytes2LongMapper.byte4ToLong( bytes.maxVMProtection );
        aRM64LcSegment.initialVMProtection = bytes2LongMapper.byte4ToLong( bytes.initialVMProtection );
        aRM64LcSegment.sectionsNum = bytes2LongMapper.byte4ToLong( bytes.sectionsNum );
        aRM64LcSegment.flags = bytes2LongMapper.byte4ToLong( bytes.flags );

        return aRM64LcSegment;
    }

    protected List<ARM64LcSegment> aRM64LcSegmentBytesListToARM64LcSegmentList(List<ARM64LcSegmentBytes> list) {
        if ( list == null ) {
            return null;
        }

        List<ARM64LcSegment> list1 = new ArrayList<ARM64LcSegment>( list.size() );
        for ( ARM64LcSegmentBytes aRM64LcSegmentBytes : list ) {
            list1.add( bytes2Model( aRM64LcSegmentBytes ) );
        }

        return list1;
    }
}
