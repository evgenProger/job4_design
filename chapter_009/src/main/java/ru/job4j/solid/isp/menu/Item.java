package ru.job4j.solid.isp.menu;

import java.util.ArrayList;
import java.util.List;

public class Item {

    private Action action;

    private String name;
    private final List<Item> items = new ArrayList<>();


     public Item(String name, Action action) {
        this.name = name;
        this.action = action;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void deleteItem(String name) {
        items.removeIf(i -> i.getName().equals(name));
    }

    public String getName() {
        return name;
    }

    public List<Item> getItems() {
        return items;
    }


    public Action getAction() {
        return action;
    }
}
