package ru.job4j.solid.dip.violates.example.two;

import java.util.Calendar;

public class CompactCar {
    private String id;
    private String model;
    private Calendar year;
    private Client client;

    public void reserve(Client client) {
        this.client = client;
    }
    public boolean hasGPS() {
        return false;
    }
}
