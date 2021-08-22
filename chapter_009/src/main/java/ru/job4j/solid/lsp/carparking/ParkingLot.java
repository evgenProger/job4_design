package ru.job4j.solid.lsp.carparking;

public class ParkingLot {
    protected int[] numberOfParkingSpaces;

    public ParkingLot(int[] numberOfParkingSpaces) {
        this.numberOfParkingSpaces = numberOfParkingSpaces;
    }

    public int[] getNumberOfParkingSpaces() {
        return numberOfParkingSpaces;
    }
}
