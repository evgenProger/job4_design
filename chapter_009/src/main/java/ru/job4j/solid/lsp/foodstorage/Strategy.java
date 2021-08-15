package ru.job4j.solid.lsp.foodstorage;

import java.util.List;

public interface Strategy {

    List<Food> direct(Food food);
}
