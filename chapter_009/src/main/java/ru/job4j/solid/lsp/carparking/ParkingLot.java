package ru.job4j.solid.lsp.carparking;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot implements ParkingSpaces {

    private List<Car> cars = new ArrayList<>();

    public ParkingLot(int numbersSpacesForLightCar, int numbersSpacesForTruck) {
        Car[] lightCar = new Car[numbersSpacesForLightCar];
        Car[] truck = new Car[numbersSpacesForTruck];
    }


    @Override
    public List<Car> getCars() {
        return cars;
    }

    @Override
    public void add(Car car) {
        cars.add(car);
    }
}






