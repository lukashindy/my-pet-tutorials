package com.github.lukashindy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@TestConfiguration
public class TestConfig {

    @Autowired
    private Environment environment;

    @Bean("testRestAddress")
    public String restAddress() {
        return environment.getProperty("rest-address", String.class);
    }
}
