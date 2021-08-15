package ru.job4j.solid.lsp.foodstorage;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

public class Warehouse implements Strategy {
    ControlQuality controlQuality;

    @Override
    public List<Food> direct(Food food) {


         return null;
    }
}
