package com.github.lukashindy.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CallService {
    private final String restAddress;
    private final RestTemplate restTemplate;

    public CallService(@Value("${rest-address}") String restAddress,
                       @Qualifier("callRestTemplate") RestTemplate restTemplate) {
        this.restAddress = restAddress;
        this.restTemplate = restTemplate;
    }

    public String getMessage() {
        return restTemplate.getForObject(restAddress, String.class);
    }
}
