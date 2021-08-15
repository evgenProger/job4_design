package ru.job4j.solid.lsp.foodstorage;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Shop implements Strategy {

    @Override
    public List<Food> direct(Food food) {
        List<Food> foods = new ArrayList<>();
        long expiryInMillis = food.getExpiryDate().getTimeInMillis();
        long now = Calendar.getInstance().getTimeInMillis();
        long left = (expiryInMillis - now);
        long totalExpiry = expiryInMillis - food.getCreateDate().getTimeInMillis();
        if ((left * 1.0 / totalExpiry) * 100 > 25 && (left * 1.0 / totalExpiry) * 100 <=75) {
            foods.add(food);
        }
        return foods;
    }
}
