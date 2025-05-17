package com.example.skb_spring.event;

import com.example.skb_spring.model.Chocolate;

public record AddOrderEvent(Integer count, Chocolate chocolate) {
}