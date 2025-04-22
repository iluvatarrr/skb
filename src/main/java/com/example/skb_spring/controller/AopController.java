package com.example.skb_spring.controller;

import com.example.skb_spring.annotation.RequestLimit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class AopController {

    @RequestLimit
    @GetMapping("/aop")
    public void checkAOP() {
        log.info("AOP RateLimit");
    }
}
