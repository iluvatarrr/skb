package ru.skb.consumer.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import ru.skb.consumer.dto.MessageDto;

@Slf4j
@Service
public class ConsumerListener {

    @KafkaListener(
            containerFactory = "consumerListenerContainerFactory",
            topics = "${spring.kafka.consumer.message.topic}",
            groupId = "${spring.kafka.consumer.message.group-id}")
    public void onMessage(@Payload MessageDto messageDto) {
        log.info("onMessage:id - {}", messageDto.id());
        log.info("onMessage:message - {}", messageDto.message());
    }
}
