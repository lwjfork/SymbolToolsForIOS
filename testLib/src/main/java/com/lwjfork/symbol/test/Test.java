package com.lwjfork.symbol.test;

import com.lwjfork.symbol.ios.ParseIOSSymbol;
import com.lwjfork.symbol.ios.constant.CPUType;
import com.lwjfork.symbol.ios.model.common.base.BaseSymbol;
import com.lwjfork.symbol.ios.model.common.section.SectionContent;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.function.Consumer;

// lwjfork@gmail.com

public class Test {



    public static String filePath = System.getProperty("user.dir")+"/testLib/src/resources/testpod";


    public static String outPutFilePath = System.getProperty("user.dir") + "/testLib/build/outPut";

    public static void main(String[] args) throws IOException, InterruptedException {
        File outDir = new File(outPutFilePath);

        FileUtils.deleteDirectory(outDir);


        FileUtils.forceMkdir(outDir);

        ParseIOSSymbol parseIOSSymbol = new ParseIOSSymbol();
        List<BaseSymbol> baseSymbols = parseIOSSymbol.parseSymbol(filePath);

        baseSymbols.forEach(new Consumer<BaseSymbol>() {
            @Override
            public void accept(BaseSymbol baseSymbol) {
                long cpuType = baseSymbol.cpuType;
                baseSymbol.section.forEach(new Consumer<SectionContent>() {
                    @Override
                    public void accept(SectionContent sectionContent) {
                        try {
                            writeSection(cpuType, sectionContent);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });

    }

    public static void writeSection(String cpuType, SectionContent sectionContent) throws IOException {
        File dir = new File(outPutFilePath, cpuType + File.separator + sectionContent.segmentName);
        if (!dir.exists()) {
            FileUtils.forceMkdir(dir);
        }
        File outPutFile = new File(dir, sectionContent.sectionName + ".txt");
        FileUtils.writeStringToFile(outPutFile, sectionContent.content);

    }


    public static void writeSection(long cpuType, SectionContent sectionContent) throws IOException {

        if (cpuType == CPUType.ARM) {
            writeSection("arm", sectionContent);
        } else if (cpuType == CPUType.ARM64) {
            writeSection("arm64", sectionContent);
        }


    }

}
