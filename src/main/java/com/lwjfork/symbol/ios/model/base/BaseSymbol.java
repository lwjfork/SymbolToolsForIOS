package com.lwjfork.symbol.ios.model.base;

import com.lwjfork.symbol.ios.model.command.LoadCommand;

public abstract class BaseSymbol<MachHeader extends BaseMachHeader> {

    public MachHeader machHeader;

    public LoadCommand command;

}
