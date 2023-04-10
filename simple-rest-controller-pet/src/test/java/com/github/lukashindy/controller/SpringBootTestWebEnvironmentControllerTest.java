package com.github.lukashindy.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.lukashindy.dto.Info;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringBootTestWebEnvironmentControllerTest {

    @Value(value="${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;
    @Test
    void testRandomUid() throws JsonProcessingException {
        String str = restTemplate.getForObject("http://localhost:" + port + "/", String.class);
        Info info = new ObjectMapper().readValue(str, Info.class);
        assertThat(str).contains("uid =");
        assertThat(info).isNotNull();
    }
}