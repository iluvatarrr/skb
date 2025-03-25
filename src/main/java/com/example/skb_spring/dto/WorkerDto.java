package com.example.skb_spring.dto;

import com.example.skb_spring.validation.AdulthoodConstraint;
import com.example.skb_spring.validation.JunRange;
import jakarta.validation.constraints.NotBlank;

public record WorkerDto(
        @NotBlank
        String name,
        @AdulthoodConstraint // кастомная
        Integer age,
        @JunRange // объединение мин и макс под удобным говорящим названием
        Integer experienceYears) {
}
