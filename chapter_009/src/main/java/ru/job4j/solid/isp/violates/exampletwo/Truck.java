package ru.job4j.solid.isp.violates.exampletwo;

public class Truck implements ITransportVehicle {

    @Override
    public void move(double speed) {
        System.out.println("Moving at speed" + speed + "mph");
    }

    @Override
    public void fly(double altitude) {
        System.out.println("Are you high?");
    }

    /*
    Obviously, trucks can’t fly, but the interface TransportVehicle nonsensically imposes the implementation of the fly
     method even for ground vehicles. One way to fix this is by segregating the interface into one interface
     for ground vehicles, and one for aircraft
     */

    // https://medium.com/swlh/solid-principles-of-oop-c24bd6ccde77
}
