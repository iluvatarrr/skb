package com.example.skb_spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseExcDto {
    private Integer code;
    private String message;
    private List<FieldErrorDto> fields;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class FieldErrorDto {
        private String field;
        private String fieldMessage;
        private Object rejectedValue;
    }
}
