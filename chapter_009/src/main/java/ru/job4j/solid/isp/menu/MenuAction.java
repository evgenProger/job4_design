package ru.job4j.solid.isp.menu;

import java.util.function.Predicate;

public class MenuAction {

    Item item;

    public MenuAction(Item item) {
        this.item = item;
    }


    public void add(Item it, String name) {
        Item point = findItem(name);
        point.addItem(it);
    }

    public void delete(String name) {
        Item item = findParent(name);
        item.deleteItem(name);

    }

    private Item findItem(Item it, Predicate<Item> predicate) {
         if (predicate.test(it)) {
             return it;
         } else {
             for (Item i: it.getItems()) {
                 if (findItem(i, predicate) != null) {
                     return findItem(i, predicate);
                 }
             }
         }
         return null;
    }

    public Item findItem(String name) {
       return findItem(item, i -> i.getName().equals(name));
    }

    public Item findParent(String name) {
      return  findItem(item, i -> i.getItems().stream().anyMatch(n -> n.getName().equals(name)));
    }

    public void print(Item it, String tab) {
        for (Item i: it.getItems()) {
            System.out.println(tab + i.getName());
            if (i.getItems().size() != 0) {
               print(i, tab + "\t");
            }
        }
    }

    public Item getItem() {
        return item;
    }
}
