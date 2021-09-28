package ru.job4j.solid.isp.violates.exampletwo;

public class Airplane implements ITransportVehicle {

    @Override
    public void Move(double speed) {
        System.out.println("Moving at speed" + speed + "mph");
    }

    @Override
    public void Fly(double altitude) {
        System.out.println("Flying at altitude" + altitude + "feet");
    }
}
