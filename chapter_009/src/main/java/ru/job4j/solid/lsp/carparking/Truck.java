package ru.job4j.solid.lsp.carparking;

public class Truck extends Car {

    public Truck(int size) {
        super(size);
    }

    @Override
    public boolean move(ParkingSpaces parkingSpaces) {
        return false;
    }
}


