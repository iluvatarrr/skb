package ru.skb.producer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.skb.producer.dto.MessageDto;

@RequiredArgsConstructor
@Slf4j
@Service
public class ProducerService {

    @Value("${spring.kafka.producer.topic.name}")
    private String topic;

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessage() {
        kafkaTemplate.send(topic, new MessageDto(1, "I am alive"))
                .thenRun(() -> {
                    log.info("Message---run");
                })
                .exceptionally((error) -> {
                    log.error("Message---error", error);
                    return null;
                });
    }

}
