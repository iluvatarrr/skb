package com.example.skb_spring.aop;

import com.example.skb_spring.exception.RequestLimitException;
import jakarta.validation.constraints.Min;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Aspect
@Slf4j
@Component
@Validated
public class AopApiAspect {

    private final Map<String, Integer> requestsCountMap = new ConcurrentHashMap<>();

    @Value("${max-request-count}")
    @Min(value = 1)
    private Integer maxRequestCount;

    @Before("@annotation(com.example.skb_spring.annotation.RequestLimit)")
    public void beforeRequestLimit(JoinPoint joinPoint) {
        var methodName = joinPoint.getSignature().toShortString();
        var currentCount = requestsCountMap.getOrDefault(methodName, 0);
        if (currentCount >= maxRequestCount) {
            throw new RequestLimitException("Too many requests for method: " + methodName);
        }
        requestsCountMap.put(methodName, currentCount + 1);
    }

}
