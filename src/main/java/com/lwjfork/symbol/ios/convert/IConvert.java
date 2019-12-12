package com.lwjfork.symbol.ios.convert;

public interface IConvert<T> {
    T convert(byte[] bytes);
}
