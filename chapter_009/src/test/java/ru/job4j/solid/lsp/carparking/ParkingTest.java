package ru.job4j.solid.lsp.carparking;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ParkingTest {

   @Test
    public void whenParkingLotForBothFreeThenTrue() {
       Car lightCar = new LightCar();
       Car truck = new Truck(3);
       ParkingSpaces parkingLot = new ParkingLot(1, 1);
       assertTrue(lightCar.move(parkingLot));
       assertTrue(truck.move(parkingLot));
       assertThat(parkingLot.getCars().get(0), is(lightCar));
       assertThat(parkingLot.getCars().get(1), is(truck));
   }

   @Test
   public void whenForTruckNotSpaceThenFalse() {
      Car truck = new Truck(3);
      ParkingSpaces parkingLot = new ParkingLot(1, 0);
      assertFalse(truck.move(parkingLot));
      assertTrue(parkingLot.getCars().isEmpty());
   }

   @Test
   public void whenLightCarParkingFreeForTruckThenTrue() {
      Car lightCar = new LightCar();
      Car truck = new Truck(3);
      ParkingSpaces parkingLot = new ParkingLot(3, 0);
      assertTrue(truck.move(parkingLot));
      assertFalse(lightCar.move(parkingLot));
      assertThat(parkingLot.getCars().get(0), is(truck));
      assertThat(parkingLot.getCars().size(), is(1));
   }

   @Test
   public void whenOneLightCarAndOneTruckThenTrue() {
      Car lightCar = new LightCar();
      Car truck = new Truck(3);
      ParkingSpaces parkingLot = new ParkingLot(4, 0);
      assertTrue(lightCar.move(parkingLot));
      assertTrue(truck.move(parkingLot));
   }
}
