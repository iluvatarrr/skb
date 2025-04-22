package com.example.skb_spring.service;

import com.example.skb_spring.evetlistener.event.DefaultEvent;
import com.example.skb_spring.evetlistener.event.EntityCreatedEvent;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DefaultService {

    ApplicationEventPublisher eventPublisher;

    public void defaultMethod() {
        log.info("log DefaultEvent: defaultMethod");
        eventPublisher.publishEvent(new DefaultEvent("defaultMethod"));
    }

}