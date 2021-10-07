package ru.job4j.solid.dip.violates.example.two;

/*
Let’s take an example of a car rental company booking application, where we need to be able to reserve different
types of cars. We design our application as follows, violating the DIP.
 */

import java.util.List;

public class ReservationApp {

    public List<CompactCar> compactCars;
    public List<LuxuryCar> luxuryCars;


}
