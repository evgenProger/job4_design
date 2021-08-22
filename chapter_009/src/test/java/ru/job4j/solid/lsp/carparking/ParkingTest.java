package ru.job4j.solid.lsp.carparking;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParkingTest {
   @Test
    public void whenNumberOfParkingOneThenParkingLightCarTrue() {
       LightCar lightCar = new LightCar();
       ParkingLot parkingLot = new ParkingLot(new int[1]);
       assertTrue(lightCar.move(lightCar));
   }


}