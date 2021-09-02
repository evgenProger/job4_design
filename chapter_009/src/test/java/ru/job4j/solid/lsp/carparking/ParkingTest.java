package ru.job4j.solid.lsp.carparking;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ParkingTest {

   @Test
    public void whenParkingLotForBothFreeThenParking() {
       Car lightCar = new LightCar();
       Car truck = new Truck(3);
       ParkingSpaces parkingLot = new ParkingLot(1, 1);
       Ticket ticketForLightCar = lightCar.move(parkingLot);
       Ticket ticketForTruck = truck.move(parkingLot);
       assertThat(parkingLot.getCars(ticketForLightCar), is(lightCar));
       assertThat(parkingLot.getCars(ticketForTruck), is(truck));
   }

   @Test
   public void whenForTruckNotSpaceThenParkingFail() {
      Car truck = new Truck(3);
      ParkingSpaces parkingLot = new ParkingLot(1, 0);
      Ticket ticket =  truck.move(parkingLot);
      assertNull(parkingLot.getCars(ticket));
   }

   @Test
   public void whenLightCarParkingFreeForTruckThenTrue() {
      Car truck = new Truck(3);
      Car lightCar = new LightCar();
      ParkingSpaces parkingLot = new ParkingLot(3, 0);
      Ticket ticketForTruck = truck.move(parkingLot);
      Ticket ticketForLightCaR = lightCar.move(parkingLot);
      assertThat(parkingLot.getCars(ticketForTruck), is(truck));
      assertNull(parkingLot.getCars(ticketForLightCaR));
   }

   @Test
   public void whenOneLightCarAndOneTruckThenTrue() {
      Car lightCar = new LightCar();
      Car truck = new Truck(3);
      ParkingSpaces parkingLot = new ParkingLot(4, 0);
      Ticket ticketForTruck = truck.move(parkingLot);
      Ticket ticketForLightCaR = lightCar.move(parkingLot);
      assertThat(parkingLot.getCars(ticketForTruck), is(truck));
      assertThat(parkingLot.getCars(ticketForLightCaR), is(lightCar));
   }
}
