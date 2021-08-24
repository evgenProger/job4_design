package ru.job4j.solid.lsp.carparking;

public class Truck extends Car implements Parking {

    public Truck(int size) {
        super(size);
    }

    @Override
    public boolean move(Car car, ParkingLot parkingLot) {
        return false;
    }
}
