package ru.job4j.solid.lsp.foodstorage;

import java.util.ArrayList;
import java.util.List;

public class Context {

    Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public List<Food> executeStrategy(Food food) {
        List<Food> foods = new ArrayList<>(strategy.direct(food));
        return foods;
    }
}
