package ru.job4j.solid.lsp.carparking;

public class LightCar extends Car {

    @Override
    public boolean move(Car car) {
        return false;
    }
}
