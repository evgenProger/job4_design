package ru.job4j.solid.lsp.carparking;

public class Truck extends Car {
    @Override
    public boolean move(Car car) {
        return false;
    }
}
