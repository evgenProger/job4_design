package ru.job4j.solid.lsp.carparking;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParkingTest {

   @Test
    public void whenParkingLotForLightCarFreeThenTrue() {
       LightCar lightCar = new LightCar();
       ParkingLot parkingLot = new ParkingLot(new Car[1]);
       assertTrue(lightCar.move(lightCar, parkingLot ));
   }

   @Test
   public void whenParkingLotForLightCarTakenThenFalse() {
      LightCar lightCar = new LightCar();
      Truck truck = new Truck(3);
      ParkingLot parkingLot = new ParkingLot(new Car[] {truck, truck , truck});
      assertFalse(lightCar.move(lightCar, parkingLot));
   }

   @Test
   public void whenParkingLotNumberOneForTruckTakenThenFalse() {
      LightCar lightCar = new LightCar();
      Truck truck = new Truck(3);
      ParkingLot parkingLot = new ParkingLot(new Car[] {lightCar, null, null});
      assertFalse(lightCar.move(truck, parkingLot));
   }

   @Test
   public void whenParkingLotNumberTwoForTruckTakenThenFalse() {
      LightCar lightCar = new LightCar();
      Truck truck = new Truck(3);
      ParkingLot parkingLot = new ParkingLot(new Car[] {null, lightCar, null});
      assertFalse(lightCar.move(truck, parkingLot));
   }

   @Test
   public void whenParkingLotNumberThreeForTruckTakenThenFalse() {
      LightCar lightCar = new LightCar();
      Truck truck = new Truck(3);
      ParkingLot parkingLot = new ParkingLot(new Car[] {null, null, lightCar});
      assertFalse(lightCar.move(truck, parkingLot));
   }

   @Test
   public void whenParkingLotForTruckFreeThenTrue() {
      Truck truck = new Truck(3);
      ParkingLot parkingLot = new ParkingLot(new Car[3]);
      assertTrue(truck.move(truck, parkingLot ));
   }

   @Test
   public void whenParkingLotForLightCarAtFirstThenTrue() {
      LightCar lightCar = new LightCar();
      Truck truck = new Truck(3);
      ParkingLot parkingLot = new ParkingLot(new Car[] {null, truck, truck, truck});
      assertTrue(lightCar.move(lightCar, parkingLot));
   }

   @Test
   public void whenParkingForBothCarsFree() {
      LightCar lightCar = new LightCar();
      Truck truck = new Truck(3);
      ParkingLot parkingLot = new ParkingLot(new Car[4]);
      assertTrue(lightCar.move(lightCar, parkingLot));
      assertTrue(truck.move(truck, parkingLot));
   }

   @Test
   public void whenParkingLotForLightCarAtTheEndThenTrue() {
      LightCar lightCar = new LightCar();
      Truck truck = new Truck(3);
      ParkingLot parkingLot = new ParkingLot(new Car[] {truck, truck, truck, null});
      assertTrue(lightCar.move(lightCar, parkingLot));
   }
}