package com.lwjfork.symbol.ios.mapper.arm64;

import com.lwjfork.symbol.tools.model.Byte16;
import org.mapstruct.Named;

import java.util.Arrays;

@Named(UUIDMapper.UUIDMapper)
public class UUIDMapper {

    public static final String UUIDMapper = "UUIDMapper";

    public static final String CONVERT_UUID = "convertUUID";

    @Named(CONVERT_UUID)
    public String convertUUID(Byte16 byte16) {
        String originStr = byte16.convert2HexStr();

        StringBuilder stringBuilder = new StringBuilder();


        char[] originChars = originStr.toCharArray();

        // 15C7CCB4_80C2_38D8_BE20_521937F7B39D
        char[] firstChars = Arrays.copyOfRange(originChars, 0, 8);
        char[] secondChars = Arrays.copyOfRange(originChars, 8, 12);
        char[] thirdChars = Arrays.copyOfRange(originChars, 12, 16);
        char[] forthChars = Arrays.copyOfRange(originChars, 16, 20);
        char[] fifthChars = Arrays.copyOfRange(originChars, 20, 32);
        stringBuilder.append(firstChars).append("_");
        stringBuilder.append(secondChars).append("_");
        stringBuilder.append(thirdChars).append("_");
        stringBuilder.append(forthChars).append("_");
        stringBuilder.append(fifthChars);

        return stringBuilder.toString();
    }


}
