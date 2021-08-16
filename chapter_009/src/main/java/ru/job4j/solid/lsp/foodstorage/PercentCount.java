package ru.job4j.solid.lsp.foodstorage;

import java.util.Calendar;

public class PercentCount {
    public double percentExpired(Food food) {
        long expiryInMillis = food.getExpiryDate().getTimeInMillis();
        long now = Calendar.getInstance().getTimeInMillis();
        long left = (expiryInMillis - now);
        long totalExpiry = expiryInMillis - food.getCreateDate().getTimeInMillis();
        return (left * 1.0 / totalExpiry) * 100;
    }
}
