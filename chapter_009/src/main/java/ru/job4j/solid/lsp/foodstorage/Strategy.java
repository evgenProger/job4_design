package ru.job4j.solid.lsp.foodstorage;

import java.util.List;
import java.util.function.Predicate;

public interface Strategy {

    List<Food> direct(Food food, Predicate<Double> predicate);
}
