package com.example.skb_spring.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ReceiptIn {
    private double price;
    private Info info;

    @Data
    @Builder
    public static class Info {
        Date date;
    }
}
