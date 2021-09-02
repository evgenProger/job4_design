package ru.job4j.solid.lsp.carparking;

public interface ParkingSpaces {
    public Car getCars(Ticket ticket);
    public void add(Car car);
}

