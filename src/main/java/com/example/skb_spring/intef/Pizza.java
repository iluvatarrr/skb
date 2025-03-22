package com.example.skb_spring.intef;

import com.example.skb_spring.intef.ingredients.Cheese;
import com.example.skb_spring.intef.ingredients.Clams;
import com.example.skb_spring.intef.ingredients.Dough;
import com.example.skb_spring.intef.ingredients.Sauce;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

public abstract class Pizza {
    @Getter
    @Setter
    public String name;
    public Dough dough;
    public Sauce sauce;
    public Cheese cheese;
    public Clams clam;

    public abstract void prepare();
    public abstract void setIngredientFactory(PizzaIngredientFactory ingredientFactory);
    public void bake() {
        System.out.println("Bake for 25 minutes at 350");
    }
    public void cut() {
        System.out.println("Cutting the pizza into diagonal slices");
    }
    public void box() {
        System.out.println("Place pizza in official PizzaStore box");
    }
}