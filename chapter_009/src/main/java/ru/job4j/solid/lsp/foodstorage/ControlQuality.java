package ru.job4j.solid.lsp.foodstorage;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

public class ControlQuality implements Strategy {

    private Predicate<Double> predicate;

    public ControlQuality(Predicate<Double> predicate) {
        this.predicate = predicate;
    }

    @Override
    public List<Food> direct(Food food) {
        List<Food> foods = new ArrayList<>();
        if (predicate.test(this.percentExpired(food))) {
            foods.add(food);
        }
        return foods;
    }

    public double percentExpired(Food food) {
        long expiryInMillis = food.getExpiryDate().getTimeInMillis();
        long now = Calendar.getInstance().getTimeInMillis();
        long left = (expiryInMillis - now);
        long totalExpiry = expiryInMillis - food.getCreateDate().getTimeInMillis();
        return (left * 1.0 / totalExpiry) * 100;
    }
}