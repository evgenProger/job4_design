package ru.job4j.solid.isp.menu;

public class AddItem extends BaseUpdate {


    protected AddItem(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, MenuAction menu) {
        Action action;
        System.out.println("---Добавление пункта меню---");
        String name = input.ask("Введите имя добавляемого пункта");
        String target = input.ask("Введите имя пункта к которому хотите добавить подпункт");
        String questinAction = input.ask("Выберите действие с пунктом меню "
                        + "\n" + "1. Распечать"
                        +   "\n" + "2. Сканировать");


        if (questinAction.equals("1")) {
            action = new PrintAction();
        } else {
            action = new ScanAction();
        }
        Item item = new Item(name, action);
        menu.add(item, target);
        System.out.println("-----Новый пункт меню" + " " +  item.getName());
    }
}
