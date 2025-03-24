package com.example.skb_spring.controller;

import com.example.skb_spring.intef.PizzaStore;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
@AllArgsConstructor
public class PizzaController {
    //в угоду задания сделал разные способы DI у похожих компонентов,
    // через поле в классе NYPizzaStore и ChicagoPizzaStore

    //конструктор
    private final PizzaStore NYPizzaStore;

    //сеттер
    private PizzaStore chicagoPizzaStore;

    @Autowired
    public void setChicagoPizzaStore(PizzaStore chicagoPizzaStore) {
        this.chicagoPizzaStore = chicagoPizzaStore;
    }

    @GetMapping("NYPizza")
    public String getNYCheesePizza(Model model) {
        //после упрощения кода и абстракций фабрика стала делать только сырную пиццу и то текстом)
        //http://localhost:8081/NYPizza - пример ссылки
        var pizza = getPizza(NYPizzaStore.createPizza());
        model.addAttribute("pizza", pizza);
        return "NY";
    }

    @GetMapping("ChicagoPizza")
    public String getChicagoCheesePizza(Model model) {
        //после упрощения кода и абстракций фабрика стала делать только сырную пиццу и то текстом)
        //http://localhost:8081/ChicagoPizza - пример ссылки
        var pizza = getPizza(chicagoPizzaStore.createPizza());
        model.addAttribute("pizza", pizza);
        return "chicago";
    }

    public String getPizza(String pizza) {
        return "it's was a %s".formatted(pizza);
    }

    @PostConstruct
    public void init() {
        log.info("Pizza Controller bean initialized!");
    }

    @PreDestroy
    public void destroy() {
        log.info("Pizza Controller bean destroyed!");
    }
}