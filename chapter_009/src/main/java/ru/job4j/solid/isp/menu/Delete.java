package ru.job4j.solid.isp.menu;

public class Delete extends BaseUpdate {


    protected Delete(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, MenuAction menu) {
        System.out.println("-----Удаление пункта меню----");
        String nameDel = input.ask("Введите имя удаляемого пункта меню");
        menu.delete(nameDel);
    }
}
