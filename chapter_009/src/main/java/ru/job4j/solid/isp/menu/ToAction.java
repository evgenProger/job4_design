package ru.job4j.solid.isp.menu;

public class ToAction extends BaseUpdate {


    protected ToAction(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, MenuAction menu) {
        System.out.println("----Выполнение задачи-----");
        String nameItem = input.ask("Введите имя пунктв меня с которым будет выполнено действие");
        Item item = menu.findItem(nameItem);
        item.getAction().action();


    }
}
