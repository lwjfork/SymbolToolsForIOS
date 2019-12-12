package com.lwjfork.symbol.ios.model.command;

import com.lwjfork.symbol.ios.model.base.BaseCommand;

public class LoadCommandUUID extends BaseCommand {

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
