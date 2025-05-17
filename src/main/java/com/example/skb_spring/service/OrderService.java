package com.example.skb_spring.service;

import com.example.skb_spring.dto.OrderIn;
import com.example.skb_spring.dto.OrderOut;
import com.example.skb_spring.event.AddOrderEvent;
import com.example.skb_spring.model.Order;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor()
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class OrderService {

    ApplicationEventPublisher applicationEventPublisher;
    List<Order> orders = new ArrayList<>();

    public OrderOut addOrder(OrderIn orderIn) {
        var order = toModel(orderIn);
        orders.add(order);
        applicationEventPublisher.publishEvent(new AddOrderEvent(order.getCount(), order.getChocolate()));
        return toDto(order);

    }


    public Order toModel(OrderIn orderIn) {
        return Order.builder()
                .id(orders.size() + 1)
                .count(orderIn.count())
                .chocolate(orderIn.chocolate())
                .build();
    }

    private OrderOut toDto(Order order) {
        return OrderOut.builder()
                .id(order.getId())
                .count(order.getCount())
                .chocolate(order.getChocolate())
                .build();
    }
}