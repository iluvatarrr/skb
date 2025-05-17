package com.example.skb_spring.listener;

import com.example.skb_spring.event.AddOrderEvent;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Component
public class OrderListener {

    MeterRegistry meterRegistry;

    @EventListener
    public void addOrderEvent(AddOrderEvent addOrderEvent) {
        meterRegistry.counter(String.format("custom.statistic.%s",addOrderEvent.chocolate())).increment(addOrderEvent.count());
    }

}