package ru.job4j.solid.lsp.carparking;

public class Truck extends Car implements Parking {

    public Truck(int size, int numberOfParkingSpaces) {
        super(size, numberOfParkingSpaces);
    }

    @Override
    public boolean move(Car car) {
        return false;
    }
}
