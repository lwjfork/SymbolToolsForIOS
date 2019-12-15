package com.lwjfork.symbol.test;

import com.lwjfork.symbol.ios.ParseIOSSymbol;
import com.lwjfork.symbol.ios.constant.CPUType;
import com.lwjfork.symbol.ios.model.common.base.BaseSymbol;
import com.lwjfork.symbol.ios.model.common.section.SectionContent;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

// lwjfork@gmail.com

public class Test {


    public static String filePath = System.getProperty("user.dir") + "/testLib/src/resources/testpod";


    public static String outPutFilePath = System.getProperty("user.dir") + "/testLib/build/outPut";

    public static void main(String[] args) throws IOException, InterruptedException {
        File outDir = new File(outPutFilePath);

        FileUtils.deleteDirectory(outDir);


        FileUtils.forceMkdir(outDir);

        ParseIOSSymbol parseIOSSymbol = new ParseIOSSymbol();
        List<BaseSymbol> baseSymbols = parseIOSSymbol.parseSymbol(filePath);

        for (BaseSymbol baseSymbol : baseSymbols) {
            writeContent(baseSymbol);
        }
    }

    public static void writeStringTable(String cpuType, String stringTable) throws IOException {
        File dir = new File(outPutFilePath, cpuType);
        if (!dir.exists()) {
            FileUtils.forceMkdir(dir);
        }
        File outPutFile = new File(dir, "stringTable.txt");
        FileUtils.writeStringToFile(outPutFile, stringTable);

    }


    public static void writeSection(String cpuType, SectionContent sectionContent) throws IOException {
        File dir = new File(outPutFilePath, cpuType + File.separator + sectionContent.segmentName);
        if (!dir.exists()) {
            FileUtils.forceMkdir(dir);
        }
        File outPutFile = new File(dir, sectionContent.sectionName + ".txt");
        FileUtils.writeStringToFile(outPutFile, sectionContent.content);

    }


    public static void writeContent(BaseSymbol symbol) throws IOException {
        writeContent(symbol.cpuType, symbol);
    }


    public static void writeContent(long cpuType, BaseSymbol symbol) throws IOException {

        String cpuName = "";

        if (cpuType == CPUType.ARM) {
            cpuName = "arm";

        } else if (cpuType == CPUType.ARM64) {
            cpuName = "arm64";
        }

        if (cpuName.length() > 0) {
            writeStringTable(cpuName, symbol.stringTable.content);
            for (SectionContent sectionContent : symbol.section) {
                writeSection(cpuName, sectionContent);
            }
        }

    }

}
