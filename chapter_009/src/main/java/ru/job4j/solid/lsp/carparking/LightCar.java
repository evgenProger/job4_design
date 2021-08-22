package ru.job4j.solid.lsp.carparking;

public class LightCar extends Car implements Parking {
    private final static  int size = 1;

    public LightCar() {
        super(size);

    }

    @Override
    public boolean move(Car car) {
        return false;
    }
}
