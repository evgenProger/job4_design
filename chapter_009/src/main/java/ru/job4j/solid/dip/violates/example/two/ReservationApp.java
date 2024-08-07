package ru.job4j.solid.dip.violates.example.two;

import java.util.List;

public class ReservationApp {

    public List<CompactCar> compactCars;
    public List<LuxuryCar> luxuryCars;


    public ReservationApp(List<CompactCar> compactCars, List<LuxuryCar> luxuryCars) {
        this.compactCars = compactCars;
        this.luxuryCars = luxuryCars;
    }

    public boolean reserveCompact(CompactCar car, Client client) {
        if (!compactCars.contains(car) && client != null) {
            car.reserve(client);
            return true;
        } else {
            System.out.println("The car was not found or is reserved");
            return false;
        }
    }

    public boolean reserveLux(LuxuryCar car, Client client) {
        if (!luxuryCars.contains(car) && client != null) {
            car.reserve(client);
            return true;
        } else {
            System.out.println("The car was not found or is reserved");
            return false;
        }
    }


    public List<CompactCar> getCompactCars() {
        return compactCars;
    }

    public void setCompactCars(List<CompactCar> compactCars) {
        this.compactCars = compactCars;
    }

    public List<LuxuryCar> getLuxuryCars() {
        return luxuryCars;
    }

    public void setLuxuryCars(List<LuxuryCar> luxuryCars) {
        this.luxuryCars = luxuryCars;
    }
}