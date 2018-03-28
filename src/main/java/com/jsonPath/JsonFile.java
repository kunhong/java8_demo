package com.jsonPath;

import org.apache.commons.io.IOUtils;

import java.io.IOException;

public class JsonFile {
    private String fileName;

    JsonFile(String fileName) {
        this.fileName = fileName;
    }

    String getFileWithUtil() {

        String result = "";

        ClassLoader classLoader = getClass().getClassLoader();
        try {
            result = IOUtils.toString(classLoader.getResourceAsStream(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
