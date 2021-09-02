package ru.job4j.solid.lsp.carparking;

public class Truck extends Car {

    public Truck(int size) {
        super(size);
    }

    @Override
    public Ticket move(ParkingSpaces parkingSpaces) {

        return null;
    }
}


