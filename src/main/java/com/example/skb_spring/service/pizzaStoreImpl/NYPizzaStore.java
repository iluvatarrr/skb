package com.example.skb_spring.service.pizzaStoreImpl;

import com.example.skb_spring.intef.PizzaIngredientFactory;
import com.example.skb_spring.intef.PizzaStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class NYPizzaStore extends PizzaStore {

    @Autowired
    @Qualifier("NYPizzaIngredientFactory")
    private PizzaIngredientFactory NYIngredientFactory;

    @Override
    public String createPizza() {
        return "Create Cheese Pizza from %s with %s, %s and %s".formatted(
                NYIngredientFactory.getClass().getSimpleName(),
                NYIngredientFactory.createDough().getClass().getSimpleName(),
                NYIngredientFactory.createCheese().getClass().getSimpleName(),
                NYIngredientFactory.createSauce().getClass().getSimpleName());
    }
}
