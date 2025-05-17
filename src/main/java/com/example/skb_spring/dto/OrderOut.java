package com.example.skb_spring.dto;

import com.example.skb_spring.model.Chocolate;
import lombok.Builder;

@Builder //добавил для красоты, чтобы создание было в одном стиле
public record OrderOut(Integer id, Integer count, Chocolate chocolate) {
}
