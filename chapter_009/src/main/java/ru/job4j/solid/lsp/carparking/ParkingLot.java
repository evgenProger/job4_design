package ru.job4j.solid.lsp.carparking;

public class ParkingLot {
    protected Car[] numberOfParkingSpaces;

    public ParkingLot(Car[] numberOfParkingSpaces) {
        this.numberOfParkingSpaces = numberOfParkingSpaces;
    }


    public Car[] getNumberOfParkingSpaces() {
        return numberOfParkingSpaces;
    }

    public void setNumberOfParkingSpaces(Car[] numberOfParkingSpaces) {
        this.numberOfParkingSpaces = numberOfParkingSpaces;
    }
}
