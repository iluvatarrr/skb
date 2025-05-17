package com.example.skb_spring.metric.timer;

import io.micrometer.core.instrument.MeterRegistry;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Aspect
@Component
@AllArgsConstructor
public class TimerAspect {
    MeterRegistry meterRegistry;

    @Around("@annotation(timerMetric)")
    public Object countTimeAround(TimerMetric timerMetric, ProceedingJoinPoint jp) {
        return meterRegistry.timer(String.format("my.timer.%s",timerMetric.name())).record(() ->
        {
            try {
                return jp.proceed();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        });
    }
}