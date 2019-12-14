package com.lwjfork.symbol.ios.model.common.command;

import com.lwjfork.symbol.ios.model.common.base.BaseCommand;
import lombok.Data;

@Data
public class LcUuid extends BaseCommand {

    public String uuid;


    @Override
    public String toString() {
        return "LoadCommandUUID{" +
                "uuid='" + uuid + '\'' +
                ", command=" + command +
                ", commandSize=" + commandSize +
                ", useBytesCount=" + useBytesCount +
                '}';
    }
}
