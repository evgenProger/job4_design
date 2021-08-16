package ru.job4j.solid.lsp.foodstorage;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Store {

    @Override
    public boolean accept(Food food) {
        boolean res = false;
       PercentCount percentCount = new PercentCount();
        if (percentCount.percentExpired(food) < 0) {
            res = true;
        }
        return res;
    }

    @Override
    public void add(Food food) {
        List<Food> foods = new ArrayList<>();
        foods.add(food);
    }
}
