package ru.job4j.solid.lsp.carparking;

public class LightCar extends Car implements Parking {
    private final static  int SIZE = 1;

    public LightCar() {
        super(SIZE);

    }

    @Override
    public Ticket move(ParkingSpaces parkingSpaces) {
        return parkingSpaces.add(this);

    }


}
