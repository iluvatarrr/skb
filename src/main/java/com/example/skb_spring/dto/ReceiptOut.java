package com.example.skb_spring.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.util.Date;


@Data
@Builder
public class ReceiptOut {
    private double price;
    private Info info;

    @Data
    @Builder
    public static class Info {
        Integer id;
        @JsonFormat(pattern = "yyyy-MM-dd")
        Date date;
    }
}
