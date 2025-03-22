package com.example.skb_spring.service;

import com.example.skb_spring.model.Info;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class InfoService {
    public Info createInfo(Info info, int lastId) {
        return new Info( lastId + 1, info.date());
    }
}
