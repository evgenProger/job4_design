package ru.job4j.solid.lsp.carparking;

public abstract class Car implements Parking {

    protected int size;

    public Car(int size) {
        this.size = size;
    }

    @Override
    public abstract boolean move(ParkingSpaces parkingSpaces);

}

