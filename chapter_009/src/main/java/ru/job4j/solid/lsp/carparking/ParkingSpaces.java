package ru.job4j.solid.lsp.carparking;

import java.util.List;

public interface ParkingSpaces {
    public List<Car> getCars();
    public void add(Car car);
}

