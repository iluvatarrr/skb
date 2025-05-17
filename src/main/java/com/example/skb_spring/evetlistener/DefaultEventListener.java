package com.example.skb_spring.evetlistener;

import com.example.skb_spring.evetlistener.event.DefaultEvent;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DefaultEventListener {

    @SneakyThrows
    @EventListener
    public void defaultEvent(DefaultEvent commonEvent) {
        log.info("Init: {}", commonEvent);
    }

}