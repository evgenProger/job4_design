package ru.job4j.solid.lsp.carparking;

public class ParkingLot {
    protected Car[] ParkingSpacesForLightCar;
    protected Car[] ParkingSpacesForTrack;

    public ParkingLot(Car[] parkingSpacesForLightCar, Car[] parkingSpacesForTrack) {
        ParkingSpacesForLightCar = parkingSpacesForLightCar;
        ParkingSpacesForTrack = parkingSpacesForTrack;
    }
}





