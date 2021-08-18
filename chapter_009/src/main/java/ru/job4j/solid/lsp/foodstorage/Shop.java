package ru.job4j.solid.lsp.foodstorage;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Shop implements Store {

   private List<Food> foods = new ArrayList<>();

    @Override
    public boolean accept(Food food) {
        boolean res = false;
        PercentCount percentCount = new PercentCount();
        Predicate<Double> predicate = p -> p > 25 && p <= 75;
        if (predicate.test(percentCount.percentExpired(food))) {
            res = true;
        }
        else if (percentCount.percentExpired(food) > 75) {
            food.setDiscount(10);
            res = true;
        };
        return res;
    }

    @Override
    public void add(Food food) {
        foods.add(food);
    }

    public List<Food> getFoods() {
        return foods;
    }
}
