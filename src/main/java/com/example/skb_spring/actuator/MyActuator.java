package com.example.skb_spring.actuator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Slf4j
@Component
@Endpoint(id = "timer")
public class MyActuator {

    @ReadOperation
    public String getCurrentTime() {
        log.info("My actuator, time: {}", LocalDateTime.now());
        return LocalDateTime.now().toString();
    }

}