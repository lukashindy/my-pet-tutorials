package com.github.lukashindy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

@Configuration
public class InteractionConfiguration {

    private final Environment environment;

    public InteractionConfiguration(Environment environment) {
        this.environment = environment;
    }

    @Bean("callRestTemplate")
    public RestTemplate customRestTemplate() {
        return new RestTemplateBuilder()
                .setConnectTimeout(Duration.of(500, ChronoUnit.SECONDS))
                .setReadTimeout(Duration.of(500, ChronoUnit.SECONDS))
                .build();
    }

}
