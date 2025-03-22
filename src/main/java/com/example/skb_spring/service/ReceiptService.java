package com.example.skb_spring.service;

import com.example.skb_spring.dto.ReceiptIn;
import com.example.skb_spring.dto.ReceiptOut;
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

    public ReceiptOut addToDB(ReceiptIn receipt) {
        var receiptModel = mapToModel(receipt);
        updateReceipt(receiptModel);
        DB.add(receiptModel);
        return mapToDto(receiptModel);
    }

    private Receipt mapToModel(ReceiptIn receiptIn) {
        return Receipt.builder()
                .price(receiptIn.getPrice())
                .id(null)
                .date(receiptIn.getInfo().getDate()).build();
    }

    private ReceiptOut mapToDto(Receipt receipt) {
        return ReceiptOut.builder()
                .price(receipt.getPrice())
                .info(ReceiptOut.Info.builder()
                        .id(receipt.getId())
                        .date(receipt.getDate())
                        .build()).build();
    }

    private void updateReceipt(Receipt receipt) {
        receipt.setId(DB.size() + 1);
    }
}
