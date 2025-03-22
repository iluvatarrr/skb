package com.example.skb_spring.model;

import lombok.Builder;
import lombok.Data;
import java.util.Date;

@Data
@Builder
public class Receipt {
    double price;
    Integer id;
    Date date;
}