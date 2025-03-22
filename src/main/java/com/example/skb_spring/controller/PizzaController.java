package com.example.skb_spring.controller;

import com.example.skb_spring.intef.Pizza;
import com.example.skb_spring.intef.PizzaStore;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@AllArgsConstructor()
public class PizzaController {

    private final PizzaStore NYPizzaStore;
    private final PizzaStore chicagoPizzaStore;

    @GetMapping("NYPizza")
    public String getNYCheesePizza(@RequestParam String type) {
        //cheese or clam - те, что реализованы в фабрике, хендлер неверного типа делать не стал, т.к не по заданию
        //http://localhost:8081/NYPizza?type=cheese - пример ссылки
        Pizza pizza = NYPizzaStore.orderPizza(type);
        return getPizza(pizza);
    }

    @GetMapping("ChicagoPizza")
    public String getChicagoCheesePizza(@RequestParam String type) {
        //cheese or clam - те, что реализованы в фабрике, хендлер неверного типа делать не стал, т.к не по заданию
        //http://localhost:8081/ChicagoPizza?type=clam - пример ссылки
        Pizza pizza = chicagoPizzaStore.orderPizza(type);
        return getPizza(pizza);
    }

    public String getPizza(Pizza pizza) {
        return "<h1>it's was a %s with %s and %s!</h1>".formatted(
                pizza.getName(),
                pizza.cheese.getClass().getSimpleName(),
                pizza.dough.getClass().getSimpleName());
    }

    @PostConstruct
    public void init() {
        System.out.println("Pizza Controller bean initialized");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Pizza Controller bean destroyed");
    }
}
