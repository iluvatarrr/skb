package ru.skb.consumer.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.CommonLoggingErrorHandler;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import ru.skb.consumer.dto.MessageDto;

@Configuration
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@EnableKafka
public class KafkaConfig {

    ObjectMapper objectMapper;
    KafkaProperties kafkaProperties;

    //конфиг был на паре, взял его
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, MessageDto> consumerListenerContainerFactory() {
        return buildListenerContainerFactory(MessageDto.class);
    }

    <T> ConcurrentKafkaListenerContainerFactory<String, T> buildListenerContainerFactory(Class<T> clazz) {
        var consumerFactory = new DefaultKafkaConsumerFactory<>(
                kafkaProperties.buildConsumerProperties(),
                new StringDeserializer(),
                new ErrorHandlingDeserializer<>(
                        new JsonDeserializer<>(
                                clazz, objectMapper, false
                        )
                )
        );

        var listenerContainerFactory =
                new ConcurrentKafkaListenerContainerFactory<String, T>();
        listenerContainerFactory.setConsumerFactory(consumerFactory);
        listenerContainerFactory.setCommonErrorHandler(commonLoggingErrorHandler());
        return listenerContainerFactory;
    }

    @Bean
    public CommonLoggingErrorHandler commonLoggingErrorHandler() {
        return new CommonLoggingErrorHandler();
    }

}
