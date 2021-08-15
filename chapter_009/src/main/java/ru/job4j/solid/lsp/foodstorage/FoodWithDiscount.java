package ru.job4j.solid.lsp.foodstorage;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FoodWithDiscount implements Strategy {

    @Override
    public List<Food> direct(Food food, Predicate<Double> predicate) {
        List<Food> foods = new ArrayList<>();
        ControlQuality controlQuality = new ControlQuality();
        predicate = p -> p > 75;
        if (predicate.test(controlQuality.percentExpired(food))) {
            food.setDiscount(5);
            foods.add(food);
        };
        return foods;
    }
}
