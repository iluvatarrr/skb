package com.example.skb_spring.model.pizzaImpl;

import com.example.skb_spring.intef.PizzaIngredientFactory;
import com.example.skb_spring.intef.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClamPizza extends Pizza {

    private PizzaIngredientFactory ingredientFactory;

    @Override
    public void prepare() {
        System.out.println("Preparing " + name);
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
        clam = ingredientFactory.createClam();
    }

    @Override
    @Autowired
    public void setIngredientFactory(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }
}