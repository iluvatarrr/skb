package com.example.skb_spring.evetlistener;

import com.example.skb_spring.evetlistener.event.MessageSendEvent;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MessageSendEventListener {

    @Async
    @EventListener
    @SneakyThrows
    public void messageEvent(MessageSendEvent messageSendEvent) {
        log.info("Init: {}", messageSendEvent);
        log.info("Ready: {}", messageSendEvent);
    }

}