package com.example.skb_spring.intef;

import com.example.skb_spring.intef.ingredients.Cheese;
import com.example.skb_spring.intef.ingredients.Dough;
import com.example.skb_spring.intef.ingredients.Sauce;

public interface PizzaIngredientFactory {
    Dough createDough();
    Sauce createSauce();
    Cheese createCheese();
}
