package com.example.skb_spring.model.factoryImpl;

import com.example.skb_spring.intef.PizzaIngredientFactory;
import com.example.skb_spring.intef.ingredients.Cheese;
import com.example.skb_spring.intef.ingredients.Clams;
import com.example.skb_spring.intef.ingredients.Dough;
import com.example.skb_spring.intef.ingredients.Sauce;
import com.example.skb_spring.model.ingredientsImpl.*;
import org.springframework.stereotype.Component;

@Component
public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        return new ThickCrustDough();
    }
    @Override
    public Sauce createSauce() {
        return new PlumTomatoSauce();
    }
    @Override
    public Cheese createCheese() {
        return new MozzarellaCheese();
    }
    @Override
    public Clams createClam() {
        return new FrozenClams();
    }
}
