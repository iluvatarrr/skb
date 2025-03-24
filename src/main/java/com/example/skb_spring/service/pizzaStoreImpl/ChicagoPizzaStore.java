package com.example.skb_spring.service.pizzaStoreImpl;

import com.example.skb_spring.intef.PizzaIngredientFactory;
import com.example.skb_spring.intef.PizzaStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ChicagoPizzaStore extends PizzaStore {

    @Autowired
    @Qualifier("chicagoPizzaIngredientFactory")
    private PizzaIngredientFactory chicagoIngredientFactory;

    @Override
    public String createPizza() {
        return "Create Cheese Pizza from %s with %s, %s and %s".formatted(
                chicagoIngredientFactory.getClass().getSimpleName(),
                chicagoIngredientFactory.createDough().getClass().getSimpleName(),
                chicagoIngredientFactory.createCheese().getClass().getSimpleName(),
                chicagoIngredientFactory.createSauce().getClass().getSimpleName());
    }
}
