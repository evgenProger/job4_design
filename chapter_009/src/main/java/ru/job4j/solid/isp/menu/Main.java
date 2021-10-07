package ru.job4j.solid.isp.menu;

import java.util.ArrayList;
import java.util.List;

public class Main {
   private boolean working = true;
   private Input input;
   private MenuAction menuAction;

    public Main(Input input, MenuAction menuAction) {
        this.input = input;
        this.menuAction = menuAction;
    }

    public void init() {
        Menu menu = new Menu(this.input, this.menuAction);
        List<Integer> range = new ArrayList<>();
        menu.fillActions(this);
        for (int i = 0; i  < menu.getActionsLentgh(); i++) {
            range.add(i);
        }
        do {
            menu.show();
            menu.select(input.ask("select", range));
        }
        while (this.working);
    }

    public void stop() {
        this.working = false;
    }

    public static void main(String[] args) {
        Action actionItem = new ScanAction();
        Action print = new PrintAction();
        Item menu = new Item("Menu", print);
        Item item = new Item("Task 1", actionItem);
        Item item1 = new Item("Task 2", print);
        menu.addItem(item);
        menu.addItem(item1);
        MenuAction tracker = new MenuAction(menu);
        new Main(new ValidateInput(
                new ConsoleInput()), tracker).init();
    }
}

