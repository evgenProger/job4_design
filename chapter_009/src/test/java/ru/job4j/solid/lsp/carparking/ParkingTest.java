package ru.job4j.solid.lsp.carparking;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParkingTest {
   private Car lightCar;
   private Car truck;

   @Before
   public void initialCars() {
      lightCar = new LightCar();
      truck = new Truck(3);
   }

   @Test
    public void whenParkingLotForLightCarFreeThenTrue() {
       ParkingLot parkingLot = new ParkingLot(new Car[1]);
       assertTrue(lightCar.move(lightCar, parkingLot ));
   }

   @Test
   public void whenParkingLotForLightCarTakenThenFalse() {
      ParkingLot parkingLot = new ParkingLot(new Car[] {truck, truck , truck});
      assertFalse(lightCar.move(lightCar, parkingLot));
   }

   @Test
   public void whenParkingLotNumberOneForTruckTakenThenFalse() {
      ParkingLot parkingLot = new ParkingLot(new Car[] {lightCar, null, null});
      assertFalse(lightCar.move(truck, parkingLot));
   }

   @Test
   public void whenParkingLotNumberTwoForTruckTakenThenFalse() {
      ParkingLot parkingLot = new ParkingLot(new Car[] {null, lightCar, null});
      assertFalse(lightCar.move(truck, parkingLot));
   }

   @Test
   public void whenParkingLotNumberThreeForTruckTakenThenFalse() {
      ParkingLot parkingLot = new ParkingLot(new Car[] {null, null, lightCar});
      assertFalse(lightCar.move(truck, parkingLot));
   }

   @Test
   public void whenParkingLotForTruckFreeThenTrue() {
      ParkingLot parkingLot = new ParkingLot(new Car[3]);
      assertTrue(truck.move(truck, parkingLot ));
   }

   @Test
   public void whenParkingLotForLightCarAtFirstThenTrue() {
      ParkingLot parkingLot = new ParkingLot(new Car[] {null, truck, truck, truck});
      assertTrue(lightCar.move(lightCar, parkingLot));
   }

   @Test
   public void whenParkingForBothCarsFree() {
      ParkingLot parkingLot = new ParkingLot(new Car[4]);
      assertTrue(lightCar.move(lightCar, parkingLot));
      assertTrue(lightCar.move(truck, parkingLot));
   }

   @Test
   public void whenParkingLotForLightCarAtTheEndFirstThenTrue() {
      ParkingLot parkingLot = new ParkingLot(new Car[] {truck, truck, truck, null});
      assertTrue(lightCar.move(lightCar, parkingLot));
   }
}