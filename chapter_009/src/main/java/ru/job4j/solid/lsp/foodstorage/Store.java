package ru.job4j.solid.lsp.foodstorage;

import java.util.List;

public interface Store {
    boolean accept(Food food);
    void add(Food food);
    List<Food> getFoods();
}
