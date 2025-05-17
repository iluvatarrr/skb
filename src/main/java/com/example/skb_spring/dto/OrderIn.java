package com.example.skb_spring.dto;

import com.example.skb_spring.model.Chocolate;

public record OrderIn(Integer count, Chocolate chocolate) {
}
