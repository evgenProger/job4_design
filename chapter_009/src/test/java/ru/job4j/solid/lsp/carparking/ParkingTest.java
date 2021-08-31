package ru.job4j.solid.lsp.carparking;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParkingTest {

   @Test
    public void whenParkingLotForBothFreeThenTrue() {
       LightCar lightCar = new LightCar();
       Truck truck = new Truck(3);
       ParkingLot parkingLot = new ParkingLot(1, 1);
       assertTrue(lightCar.move(lightCar, parkingLot));
       assertTrue(truck.move(truck, parkingLot));
   }

   @Test
   public void whenForTruckNotSpaceThenFalse() {
      Truck truck = new Truck(3);
      ParkingLot parkingLot = new ParkingLot(1, 1);
      assertFalse(truck.move(truck, parkingLot));
   }

   @Test
   public void whenLightCarParkingFreeForTruckThenTrue() {
      LightCar lightCar = new LightCar();
      Truck truck = new Truck(3);
      ParkingLot parkingLot = new ParkingLot(3, 1);
      assertFalse(lightCar.move(truck, parkingLot));
   }

   @Test
   public void whenOneLightCarAndOneTruckThenTrue() {
      LightCar lightCar = new LightCar();
      Truck truck = new Truck(3);
      ParkingLot parkingLot = new ParkingLot(4, 1);
      assertTrue(lightCar.move(lightCar, parkingLot));
      assertTrue(lightCar.move(truck, parkingLot));
   }
}