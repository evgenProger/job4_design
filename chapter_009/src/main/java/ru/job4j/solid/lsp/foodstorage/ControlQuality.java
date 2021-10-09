package ru.job4j.solid.lsp.foodstorage;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

public class ControlQuality {

    List<Store> stores;

    public ControlQuality(List<Store> stores) {
        this.stores = stores;
    }

    public List<Store> distribute(Food food) {
        for (Store store : stores) {
            if (store.accept(food)) {
                store.add(food);
            }
        }
        return stores;
    }

    public List<Store> resort() {
        List<Food> foods = new ArrayList<>();
        for (Store store : stores) {
            foods.addAll(store.getFoods());
            store.getFoods().clear();
        }
        for (Food f : foods) {
            stores = this.distribute(f);
        }
        return stores;
    }
}