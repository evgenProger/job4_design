package ru.job4j.solid.lsp.foodstorage;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Trash implements Strategy {

    @Override
    public List<Food> direct(Food food) {
        List<Food> foods = new ArrayList<>();
        long expiryInMillis = food.getExpiryDate().getTimeInMillis();
        long now = Calendar.getInstance().getTimeInMillis();
        long left = (expiryInMillis - now);
        if (left < 0) {
            foods.add(food);
        }
        return foods;
    }
}
