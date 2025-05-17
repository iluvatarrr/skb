package com.example.skb_spring.controller;

import com.example.skb_spring.dto.OrderIn;
import com.example.skb_spring.dto.OrderOut;
import com.example.skb_spring.metric.counter.CounterMetric;
import com.example.skb_spring.metric.timer.TimerMetric;
import com.example.skb_spring.service.OrderService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RestController
@RequestMapping("/order")
public class OrderController {

    OrderService orderService;

    @PostMapping("/add")
    @CounterMetric(name = "addOrder")
    @TimerMetric(name = "addOrder")
    public OrderOut addOrder(@RequestBody OrderIn order) {
        return orderService.addOrder(order);
    }

}