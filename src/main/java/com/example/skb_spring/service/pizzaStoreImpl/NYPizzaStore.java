package com.example.skb_spring.service.pizzaStoreImpl;

import com.example.skb_spring.intef.PizzaIngredientFactory;
import com.example.skb_spring.intef.Pizza;
import com.example.skb_spring.model.pizzaImpl.CheesePizza;
import com.example.skb_spring.model.pizzaImpl.ClamPizza;
import com.example.skb_spring.intef.PizzaStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class NYPizzaStore extends PizzaStore {

    @Autowired
    @Qualifier("NYPizzaIngredientFactory")
    private PizzaIngredientFactory NYIngredientFactory;

    protected Pizza createPizza(String item) {
        Pizza pizza = null;
        if (item.equals("cheese")) {
            pizza = new CheesePizza();
            pizza.setIngredientFactory(NYIngredientFactory);
            pizza.setName("New York Style Cheese Pizza");
        } else if (item.equals("clam")) {
            pizza = new ClamPizza();
            pizza.setIngredientFactory(NYIngredientFactory);
            pizza.setName("New York Style Clam Pizza");
        }
        return pizza;
    }
}
