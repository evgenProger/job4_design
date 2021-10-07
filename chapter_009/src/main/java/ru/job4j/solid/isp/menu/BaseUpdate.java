package ru.job4j.solid.isp.menu;

public abstract class BaseUpdate implements UpdateMenu {
    private final int key;
    private final String name;

    protected BaseUpdate(int key, String name) {
        this.key = key;
        this.name = name;
    }

    @Override
    public int key() {
        return this.key;
    }

    @Override
    public String info() {
        return String.format("%s %s", this.key, this.name);
    }

}
