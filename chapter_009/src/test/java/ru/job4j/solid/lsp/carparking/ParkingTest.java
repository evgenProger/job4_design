package ru.job4j.solid.lsp.carparking;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParkingTest {
   @Test
    public void whenParkingLotForLightCarFreeThenTrue() {
       Car lightCar = new LightCar();
       ParkingLot parkingLot = new ParkingLot(new Car[1]);
       Car[] arrParking = parkingLot.getNumberOfParkingSpaces();
       arrParking[0] = lightCar;
       parkingLot.setNumberOfParkingSpaces(arrParking);
       assertTrue(lightCar.move(lightCar, parkingLot ));
   }

   @Test
   public void whenParkingLotNumberOneForLightCarTakenThenFalse() {
      Car lightCar = new LightCar();
      Car truck = new Truck(3);
      ParkingLot parkingLot = new ParkingLot(new Car[3]);
      Car[] arrParking = parkingLot.getNumberOfParkingSpaces();
      arrParking[0] = truck;
      parkingLot.setNumberOfParkingSpaces(arrParking);
      assertFalse(lightCar.move(lightCar, parkingLot));
   }

   @Test
   public void whenParkingLotNumberTwoForLightCarTakenThenFalse() {
      Car lightCar = new LightCar();
      Car truck = new Truck(3);
      ParkingLot parkingLot = new ParkingLot(new Car[3]);
      Car[] arrParking = parkingLot.getNumberOfParkingSpaces();
      arrParking[1] = truck;
      parkingLot.setNumberOfParkingSpaces(arrParking);
      assertFalse(lightCar.move(lightCar, parkingLot));
   }

   @Test
   public void whenParkingLotNumberThreeForLightCarTakenThenFalse() {
      Car lightCar = new LightCar();
      Car truck = new Truck(3);
      ParkingLot parkingLot = new ParkingLot(new Car[3]);
      Car[] arrParking = parkingLot.getNumberOfParkingSpaces();
      arrParking[2] = truck;
      parkingLot.setNumberOfParkingSpaces(arrParking);
      assertFalse(lightCar.move(lightCar, parkingLot));
   }

   @Test
   public void whenParkingLotNumberOneForTruckTakenThenFalse() {
      Car lightCar = new LightCar();
      Car truck = new Truck(3);
      ParkingLot parkingLot = new ParkingLot(new Car[3]);
      Car[] arrParking = parkingLot.getNumberOfParkingSpaces();
      arrParking[0] = lightCar;
      parkingLot.setNumberOfParkingSpaces(arrParking);
      assertFalse(lightCar.move(truck, parkingLot));
   }

   @Test
   public void whenParkingLotNumberTwoForTruckTakenThenFalse() {
      Car lightCar = new LightCar();
      Car truck = new Truck(3);
      ParkingLot parkingLot = new ParkingLot(new Car[3]);
      Car[] arrParking = parkingLot.getNumberOfParkingSpaces();
      arrParking[1] = lightCar;
      parkingLot.setNumberOfParkingSpaces(arrParking);
      assertFalse(lightCar.move(truck, parkingLot));
   }

   @Test
   public void whenParkingLotNumberThreeForTruckTakenThenFalse() {
      Car lightCar = new LightCar();
      Car truck = new Truck(3);
      ParkingLot parkingLot = new ParkingLot(new Car[3]);
      Car[] arrParking = parkingLot.getNumberOfParkingSpaces();
      arrParking[2] = lightCar;
      parkingLot.setNumberOfParkingSpaces(arrParking);
      assertFalse(lightCar.move(truck, parkingLot));
   }

   @Test
   public void whenParkingLotForTruckFreeThenTrue() {
      Car truck = new Truck(3);
      ParkingLot parkingLot = new ParkingLot(new Car[3]);
      Car[] arrParking = parkingLot.getNumberOfParkingSpaces();
      arrParking[0] = truck;
      parkingLot.setNumberOfParkingSpaces(arrParking);
      assertTrue(truck.move(truck, parkingLot ));
   }
}