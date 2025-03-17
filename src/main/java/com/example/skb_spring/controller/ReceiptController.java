package com.example.skb_spring.controller;

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
    public Receipt addReceipt(@RequestBody Receipt receipt) {
        //dto для маленькой учебной задачи не умеет смысла логически и функционально - делать не стал
        return receiptService.addToDB(receipt);
    }

    @GetMapping("/exception")
    public void exception() {
        throw new BadGatewayException("My Exception is alive");
    }
}
