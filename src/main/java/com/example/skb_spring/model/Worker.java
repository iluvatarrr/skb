package com.example.skb_spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Worker {
    String name;
    Integer age;
    Integer experienceYears;
}
