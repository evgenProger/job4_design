package ru.job4j.solid.lsp.foodstorage;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

public class Shop implements Strategy {

    @Override
    public List<Food> direct(Food food, Predicate<Double> predicate ) {
        List<Food> foods = new ArrayList<>();
        ControlQuality controlQuality = new ControlQuality();
        predicate = p -> p > 25 && p <= 75;
        if (predicate.test(controlQuality.percentExpired(food))) {
            foods.add(food);
        };
        return foods;
    }
}
