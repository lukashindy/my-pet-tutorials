package com.github.lukashindy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReader {

    private FileReader() throws IllegalAccessException {
        throw new IllegalAccessException("Utility class");
    }

    public static String readContent(String path) throws IOException {
        return Files.readString(Paths.get(path));
    }
}
