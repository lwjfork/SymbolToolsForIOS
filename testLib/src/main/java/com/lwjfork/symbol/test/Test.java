package com.lwjfork.symbol.test;

import com.lwjfork.symbol.ios.ParseIOSSymbol;

import java.io.IOException;

// lwjfork@gmail.com

public class Test {


    public static String filePath = "/Users/liuwenjie/Downloads/buglySymboliOS2.4.3/testpod";


    public static void main(String[] args) throws IOException, InterruptedException {
        ParseIOSSymbol parseIOSSymbol = new ParseIOSSymbol();
        parseIOSSymbol.parseSymbol(filePath);


    }

}
