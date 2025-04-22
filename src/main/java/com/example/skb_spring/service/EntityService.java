package com.example.skb_spring.service;

import com.example.skb_spring.evetlistener.event.EntityCreatedEvent;
import com.example.skb_spring.evetlistener.event.EntitySubCreatedEvent;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EntityService {

    ApplicationEventPublisher eventPublisher;

    @Transactional
    public void save() {
        //TODO: тут могла быть реализация сохранения с репо и DTO
        log.info("log EntityCreatedEvent: save");
        eventPublisher.publishEvent(new EntityCreatedEvent(1));
    }

    @Transactional
    public void subSave() {
        //TODO: тут могла быть реализация сохранения с репо и DTO
        try {
            if (true) throw new RuntimeException();
            log.info("log EntityCreatedEvent: subSave (never)");
            eventPublisher.publishEvent(new EntitySubCreatedEvent(2));
        } catch (Exception exception) {
            log.error("log EntityCreatedEvent: error subSave", exception);
            throw exception;
        }
    }
}