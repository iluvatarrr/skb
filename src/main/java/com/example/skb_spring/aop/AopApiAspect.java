package com.example.skb_spring.aop;

import com.example.skb_spring.exception.RequestLimitException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class AopApiAspect {

    private int requestsCount = 0;

    @Value("${max-request-count}")
    private Integer MAX_REQUEST_COUNT;

    @Before("@annotation(com.example.skb_spring.annotation.RequestLimit)")
    public void beforeRequestLimit() {
        if (MAX_REQUEST_COUNT <= 0 || requestsCount >= MAX_REQUEST_COUNT) {
            throw new RequestLimitException("Too many requests");
        }
        requestsCount++;
        log.info(Integer.toString(requestsCount));
    }

}
