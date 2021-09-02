package ru.job4j.solid.lsp.carparking;

public class LightCar extends Car implements Parking {
    private final static  int size = 1;

    public LightCar() {
        super(size);

    }

    @Override
    public Ticket move(ParkingSpaces parkingSpaces) {
        return false;
    }
}
