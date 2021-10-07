package ru.job4j.solid.isp.menu;

public class PrintAction implements Action {

    @Override
    public void action() {
        System.out.println("Распечать");
    }
}
