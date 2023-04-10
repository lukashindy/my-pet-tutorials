package com.github.lukashindy.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CallServiceTest {

    private final String restAddress = "https://dzen.ru";

    @Mock
    private RestTemplate customRestTemplate;
    @InjectMocks
    private CallService callService;

    @BeforeEach
    void init() {
        callService = new CallService(restAddress, customRestTemplate);
    }

    @Test
    void getMessage() {
        when(customRestTemplate.getForObject(eq(restAddress), any())).thenReturn("Today I started to learn RestTemplate and Tests");
        String message = callService.getMessage();
        assertEquals("Today I started to learn RestTemplate and Tests", message);
    }
}