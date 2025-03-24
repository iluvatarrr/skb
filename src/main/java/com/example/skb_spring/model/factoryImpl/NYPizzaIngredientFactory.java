package com.example.skb_spring.model.factoryImpl;

import com.example.skb_spring.intef.PizzaIngredientFactory;
import com.example.skb_spring.intef.ingredients.Cheese;
import com.example.skb_spring.intef.ingredients.Dough;
import com.example.skb_spring.intef.ingredients.Sauce;
import com.example.skb_spring.model.ingredientsImpl.MarinaraSauce;
import com.example.skb_spring.model.ingredientsImpl.ReggianoCheese;
import com.example.skb_spring.model.ingredientsImpl.ThinCrustDough;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class NYPizzaIngredientFactory implements PizzaIngredientFactory {

    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }
    @Override
    public Sauce createSauce() {
        return new MarinaraSauce();
    }
    @Override
    public Cheese createCheese() {
        return new ReggianoCheese();
    }
}
