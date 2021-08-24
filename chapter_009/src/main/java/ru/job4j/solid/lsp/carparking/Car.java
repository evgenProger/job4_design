package ru.job4j.solid.lsp.carparking;

public abstract class Car {

    protected int size;


    public Car(int size) {
        this.size = size;
    }

    protected boolean move(Car car, ParkingLot parkingLot) {
        return false;
    }
}
