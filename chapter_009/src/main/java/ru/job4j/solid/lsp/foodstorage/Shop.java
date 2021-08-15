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
        Predicate<Double> discount = p -> p > 75;
        if (predicate.test(controlQuality.percentExpired(food))) {
            foods.add(food);
        }
         else if (discount.test(controlQuality.percentExpired(food))) {
            food.setDiscount(10);
            foods.add(food);
        };
        return foods;
    }
}
