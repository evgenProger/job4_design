package ru.job4j.solid.dip.violates.example.two;

import java.util.Calendar;

public class LuxuryCar {
    private String id;
    private String model;
    Calendar year;
    private Client client;

    public String getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public boolean hasSatelliteRoadsideAssistance() {
        return false;
    }

    public void reserve(Client client) {
        this.client = client;
    }
}
