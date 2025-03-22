package com.example.skb_spring.controller;

import com.example.skb_spring.dto.ReceiptIn;
import com.example.skb_spring.dto.ReceiptOut;
import com.example.skb_spring.exception.BadGatewayException;
import com.example.skb_spring.model.Receipt;
import com.example.skb_spring.service.ReceiptService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/receipt")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ReceiptController {

    ReceiptService receiptService;

    @PostMapping("/add")
    public ReceiptOut addReceipt(@RequestBody ReceiptIn receipt) {
        return receiptService.addToDB(receipt);
    }

    @GetMapping("/exception")
    public void exception() {
        throw new BadGatewayException("My Exception is alive");
    }
}
