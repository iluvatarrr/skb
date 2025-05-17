package ru.skb.producer.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.autoconfigure.kafka.DefaultKafkaProducerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.support.serializer.JsonSerializer;

@EnableKafka
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Configuration
public class KafkaConfig {

    ObjectMapper objectMapper;

    @Bean
    public DefaultKafkaProducerFactoryCustomizer producerFactory() {
        return (factory) -> factory.setValueSerializer(new JsonSerializer<>(objectMapper));
    }

}
