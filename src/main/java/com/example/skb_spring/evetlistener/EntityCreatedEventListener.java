package com.example.skb_spring.evetlistener;

import com.example.skb_spring.evetlistener.event.EntityCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
@Slf4j
public class EntityCreatedEventListener {

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void createEntityEvent(EntityCreatedEvent entityCreatedEvent) {
        log.info("Transactional: {}", entityCreatedEvent);
    }

}
