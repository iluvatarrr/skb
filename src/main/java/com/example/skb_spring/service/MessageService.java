package com.example.skb_spring.service;

import com.example.skb_spring.evetlistener.event.EntityCreatedEvent;
import com.example.skb_spring.evetlistener.event.MessageSendEvent;
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
public class MessageService {

    ApplicationEventPublisher eventPublisher;

    public void sendMessage() {
        //TODO: тут могла быть реализация отправки
        log.info("log MessageEvent: sendMessage");
        eventPublisher.publishEvent(new MessageSendEvent("Hello World"));
    }
}
