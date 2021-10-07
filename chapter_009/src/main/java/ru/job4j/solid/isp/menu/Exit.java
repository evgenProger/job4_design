package ru.job4j.solid.isp.menu;

public class Exit extends BaseUpdate {
    private Main main;

    protected Exit(Main input, int key, String name) {
        super(key, name);
        this.main = input;
    }


    @Override
    public void execute(Input input, MenuAction menu) {
        this.main.stop();
        System.out.println();
    }
}
