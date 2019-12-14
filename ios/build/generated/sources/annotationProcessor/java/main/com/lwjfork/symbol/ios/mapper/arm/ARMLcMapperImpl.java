package com.lwjfork.symbol.ios.mapper.arm;

import com.lwjfork.symbol.ios.mapper.common.BaseLcMapper;
import com.lwjfork.symbol.ios.model.arm.command.ARMLc;
import com.lwjfork.symbol.ios.model.arm.command.ARMLcSegment;
import com.lwjfork.symbol.ios.vo.arm.command.ARMLcBytes;
import com.lwjfork.symbol.ios.vo.arm.command.ARMLcSegmentBytes;
import com.lwjfork.symbol.tools.mapper.Bytes2LongMapper;
import com.lwjfork.symbol.tools.mapper.BytesAsciiStr2StrMapper;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.mapstruct.factory.Mappers;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-12-14T15:24:27+0800",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_221 (Oracle Corporation)"
)
public class ARMLcMapperImpl implements ARMLcMapper {

    private final Bytes2LongMapper bytes2LongMapper = new Bytes2LongMapper();
    private final BytesAsciiStr2StrMapper bytesAsciiStr2StrMapper = new BytesAsciiStr2StrMapper();
    private final BaseLcMapper baseLcMapper = Mappers.getMapper( BaseLcMapper.class );

    @Override
    public ARMLc bytes2Model(ARMLcBytes bytes) {
        if ( bytes == null ) {
            return null;
        }

        ARMLc aRMLc = new ARMLc();

        aRMLc.useBytesCount = bytes.useBytesCount;
        aRMLc.offset = bytes.offset;
        aRMLc.lcUUID = baseLcMapper.bytes2Model( bytes.lcUUID );
        aRMLc.lcSymTab = baseLcMapper.bytes2Model( bytes.lcSymTab );
        aRMLc.segments = aRMLcSegmentBytesListToARMLcSegmentList( bytes.segments );

        return aRMLc;
    }

    @Override
    public ARMLcSegment bytes2Model(ARMLcSegmentBytes bytes) {
        if ( bytes == null ) {
            return null;
        }

        ARMLcSegment aRMLcSegment = new ARMLcSegment();

        aRMLcSegment.useBytesCount = bytes.useBytesCount;
        aRMLcSegment.offset = bytes.offset;
        aRMLcSegment.command = bytes2LongMapper.byte4ToLong( bytes.command );
        aRMLcSegment.commandSize = bytes2LongMapper.byte4ToLong( bytes.commandSize );
        aRMLcSegment.segmentName = bytesAsciiStr2StrMapper.byte16AsciiToStr( bytes.segmentName );
        aRMLcSegment.VMAddress = bytes2LongMapper.byte4ToLong( bytes.VMAddress );
        aRMLcSegment.VMSize = bytes2LongMapper.byte4ToLong( bytes.VMSize );
        aRMLcSegment.fileOffset = bytes2LongMapper.byte4ToLong( bytes.fileOffset );
        aRMLcSegment.fileSize = bytes2LongMapper.byte4ToLong( bytes.fileSize );
        aRMLcSegment.maxVMProtection = bytes2LongMapper.byte4ToLong( bytes.maxVMProtection );
        aRMLcSegment.initialVMProtection = bytes2LongMapper.byte4ToLong( bytes.initialVMProtection );
        aRMLcSegment.sectionsNum = bytes2LongMapper.byte4ToLong( bytes.sectionsNum );
        aRMLcSegment.flags = bytes2LongMapper.byte4ToLong( bytes.flags );

        return aRMLcSegment;
    }

    protected List<ARMLcSegment> aRMLcSegmentBytesListToARMLcSegmentList(List<ARMLcSegmentBytes> list) {
        if ( list == null ) {
            return null;
        }

        List<ARMLcSegment> list1 = new ArrayList<ARMLcSegment>( list.size() );
        for ( ARMLcSegmentBytes aRMLcSegmentBytes : list ) {
            list1.add( bytes2Model( aRMLcSegmentBytes ) );
        }

        return list1;
    }
}
