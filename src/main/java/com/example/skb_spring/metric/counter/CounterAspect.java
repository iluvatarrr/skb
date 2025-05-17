package com.example.skb_spring.metric.counter;

import io.micrometer.core.instrument.MeterRegistry;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Aspect
@AllArgsConstructor
@Component
public class CounterAspect {
    MeterRegistry meterRegistry;

    @After("@annotation(counterMetric)")
    public void counterMetric(CounterMetric counterMetric) {
        meterRegistry.counter("my.counter.all").increment();
        meterRegistry.counter(String.format("my.counter.%s",counterMetric.name())).increment();
    }

}