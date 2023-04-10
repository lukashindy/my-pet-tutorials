package com.github.lukashindy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class FileReaderTest {

    @Test
    void readContent_txt() throws IOException {
        String message = FileReader.readContent("src/test/resources/message.txt");
        assertNotNull(message);
        log.info("\n{}", message);
    }

    @Test
    void readContent_xml() throws IOException {
        String message = FileReader.readContent("src/test/resources/request.xml");
        assertNotNull(message);
        log.info("\n{}", message);
    }

    @Test
    void readContent_json() throws IOException {
        String message = FileReader.readContent("src/test/resources/response.json");
        assertNotNull(message);
        log.info("\n{}", message);
    }
}