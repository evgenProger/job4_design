package ru.job4j.solid.lsp.foodstorage;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Shop implements Store {


 /*   public List<Food> direct(Food food) {
        List<Food> foods = new ArrayList<>();
        ControlQuality controlQuality = new ControlQuality();
        Predicate<Double> predicate = p -> p > 25 && p <= 75;
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
  */

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
        List<Food> foods = new ArrayList<>();
        foods.add(food);
    }
}
