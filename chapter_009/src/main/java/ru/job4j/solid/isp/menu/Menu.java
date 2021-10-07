package ru.job4j.solid.isp.menu;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private final Input input;
    private final MenuAction menuAction;
    private final List<UpdateMenu> actions = new ArrayList<>();

    public Menu(Input input, MenuAction menuAction) {
        this.input = input;
        this.menuAction = menuAction;
    }

    public int getActionsLentgh() {
        return this.actions.size();
    }

    public void fillActions(Main input) {
        this.actions.add(new ShowItems(0, "Вывести дерево меню"));
        this.actions.add(new AddItem(1, "Добавить новый пункт меню"));
        this.actions.add(new ToAction(2, "Выполнить пункт меню"));
        this.actions.add(new Delete(3, "Удалить пункт меню"));
        this.actions.add(new Exit(input, 4, "Выйти из программы"));
    }

    public void select(int key) {
        this.actions.get(key).execute(this.input, this.menuAction);
    }

    public void show() {
        for (UpdateMenu m: this.actions) {
            if (m != null) {
                System.out.println(m.info());
            }
        }
    }


}
