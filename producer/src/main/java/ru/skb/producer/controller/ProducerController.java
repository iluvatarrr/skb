package ru.skb.producer.controller;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.skb.producer.service.ProducerService;

@RestController
@RequestMapping("/kafka")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProducerController {

    ProducerService producerService;

    @GetMapping("/send")
    public void sendMessage() {
        producerService.sendMessage();
    }

}
