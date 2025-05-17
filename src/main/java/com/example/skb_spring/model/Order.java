package com.example.skb_spring.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Getter
@Setter
@Builder
public class Order {
    Integer id;
    Chocolate chocolate;
    Integer count;
}