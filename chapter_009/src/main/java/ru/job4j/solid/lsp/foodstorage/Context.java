package ru.job4j.solid.lsp.foodstorage;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Context {

    Predicate<Double> predicate;
    Store strategy;

    public Context(Store strategy) {
        this.strategy = strategy;
    }

    public List<Food> executeStrategy(Food food) {
        List<Food> foods = new ArrayList<>();
        foods.add(food);
        return foods;
    }
}
