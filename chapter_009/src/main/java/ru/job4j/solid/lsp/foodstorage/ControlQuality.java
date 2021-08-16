package ru.job4j.solid.lsp.foodstorage;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

public class ControlQuality  {

    List<Store> stores;

    public ControlQuality(List<Store> stores) {
        this.stores = stores;
    }

    public List<Store> distribute(Food food) {
        for (Store store: stores) {
            if (store.accept(food)) {
                store.add(food);
            }
        }
        return stores;
    }
}