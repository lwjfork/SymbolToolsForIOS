package com.lwjfork.symbol.ios.mapper.common;

import com.lwjfork.symbol.tools.mapper.BytesAsciiStr2StrMapper;
import com.lwjfork.symbol.tools.model.Byte16;
import org.mapstruct.Named;

@Named(SectionOrSegmentNamMapper.SectionOrSegmentNamMapper)
public class SectionOrSegmentNamMapper {

    public static final String SectionOrSegmentNamMapper = "SectionOrSegmentNamMapper";

    public static final String convertName = "convertName";

    @Named(convertName)
    public String convertName(Byte16 byte16) {
        return BytesAsciiStr2StrMapper.INSTANCE.byte16AsciiToStr(byte16);
    }


}
