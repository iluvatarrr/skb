package com.example.skb_spring.service.pizzaStoreImpl;

import com.example.skb_spring.intef.Pizza;
import com.example.skb_spring.intef.PizzaIngredientFactory;
import com.example.skb_spring.intef.PizzaStore;
import com.example.skb_spring.model.factoryImpl.ChicagoPizzaIngredientFactory;
import com.example.skb_spring.model.pizzaImpl.CheesePizza;
import com.example.skb_spring.model.pizzaImpl.ClamPizza;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ChicagoPizzaStore extends PizzaStore {

    @Autowired
    @Qualifier("chicagoPizzaIngredientFactory")
    private PizzaIngredientFactory chicagoIngredientFactory;

    @Override
    protected Pizza createPizza(String type) {
        Pizza pizza = null;
        if (type.equals("cheese")) {
            pizza = new CheesePizza();
            pizza.setIngredientFactory(chicagoIngredientFactory);
            pizza.setName("Chicago Style Cheese Pizza");
        } else if (type.equals("clam")) {
            pizza = new ClamPizza();
            pizza.setIngredientFactory(chicagoIngredientFactory);
            pizza.setName("Chicago Style Clam Pizza");
        }
        return pizza;
    }
}
