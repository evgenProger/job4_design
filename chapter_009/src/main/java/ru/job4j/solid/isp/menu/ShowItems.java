package ru.job4j.solid.isp.menu;

public class ShowItems extends BaseUpdate {

    protected ShowItems(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, MenuAction menu) {
        String tab = "\t";
        System.out.println("Вывести дерево меню");
        menu.print(menu.getItem(), tab);
    }
}














