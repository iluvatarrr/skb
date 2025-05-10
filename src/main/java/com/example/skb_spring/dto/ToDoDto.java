package com.example.skb_spring.dto;

import java.util.Set;

public record ToDoDto(String name, Set<String> events) {
}