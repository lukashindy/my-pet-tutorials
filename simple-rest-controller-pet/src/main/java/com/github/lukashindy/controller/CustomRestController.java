package com.github.lukashindy.controller;

import com.github.lukashindy.dto.Info;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
public class CustomRestController {

    @GetMapping
    public ResponseEntity<Info> getRandomUid() {
        String uid = UUID.randomUUID().toString();
        log.info("random generated number = '{}'", uid);
        return ResponseEntity.ok(new Info("uid = " + uid));
    }
}
