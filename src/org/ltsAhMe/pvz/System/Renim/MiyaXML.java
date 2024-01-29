package org.ltsAhMe.pvz.System.Renim;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MiyaXML {

    private String content = "";


    public MiyaXML(String content) {
        this.content = content;
    }
    public MiyaXML(File file) {
        try (FileReader fileReader = new FileReader(file)) {
            int fileData;
            while ((fileData = fileReader.read()) != -1) {
                content += (char) fileData;
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public String getTypeContent(String type, int number) {
        int startIndex = getOccurrenceIndex("<" + type + ">", number) + ("<" + type + ">").length();
        int endIndex = getOccurrenceIndex("</" + type + ">", number);

        // 处理越界情况
        if (startIndex >= 0 && endIndex >= 0 && startIndex < endIndex) {
            return content.substring(startIndex, endIndex);
        } else {
            return ""; // 或者抛出异常，取决于业务需求
        }
    }

    private int getOccurrenceIndex(String type, int number) {
        int num = 0;
        int tempChar = content.indexOf(type);
        while (content.indexOf(type, tempChar + type.length()) != -1 && num < number) {
            num++;
            tempChar = content.indexOf(type, tempChar + type.length());
        }
        return tempChar;
    }

    public int getOccurrencesCount(String type) {
        int num = 0;
        int tempChar = 0;
        while (content.indexOf(type, tempChar + type.length()) != -1) {
            num++;
            tempChar = content.indexOf(type, tempChar + type.length());
        }
        return num;
    }
}
