package com.example.skb_spring.service;

import com.example.skb_spring.model.Receipt;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ReceiptService {

    static List<Receipt> DB = new ArrayList<>();

    InfoService infoService;

    public Receipt addToDB(Receipt receipt) {
        receipt = updateReceipt(receipt);
        DB.add(receipt);
        return receipt;
    }

    private Receipt updateReceipt(Receipt receipt) {
        var info = infoService.createInfo(receipt.info(), DB.size());
        return new Receipt(receipt.price(), info);
    }
}
