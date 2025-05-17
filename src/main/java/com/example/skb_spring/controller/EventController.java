package com.example.skb_spring.controller;

import com.example.skb_spring.service.DefaultService;
import com.example.skb_spring.service.EntityService;
import com.example.skb_spring.service.MessageService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EventController {

    MessageService messageService;
    EntityService entityService;
    DefaultService defaultService;

    @GetMapping(path = "/save")
    public void checkCreate()  {
        entityService.save();
        entityService.subSave();
    }

    @GetMapping(path = "/default")
    public void checkDefault(){
        defaultService.defaultMethod();
    }

    @GetMapping(path = "/message")
    public void checkMessage(){
        messageService.sendMessage();
        messageService.sendMessage();
    }

}
