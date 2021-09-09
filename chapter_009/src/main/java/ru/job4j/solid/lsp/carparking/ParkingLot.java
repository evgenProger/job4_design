package ru.job4j.solid.lsp.carparking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ParkingLot implements ParkingSpaces {

    Random rnd = new Random();
    private final List<Car> cars = new ArrayList<>();
    private final Car[] lightCar;
    private final Car[] truck;

    public ParkingLot(int numbersSpacesForLightCar, int numbersSpacesForTruck) {
        lightCar = new Car[numbersSpacesForLightCar];
        truck = new Car[numbersSpacesForTruck];
    }

    @Override
    public Car getCars(Ticket ticket) {
        mergePark();
        Car car = null;
        for (Car carValue: cars) {
            if (carValue != null && carValue.getTicket().equals(ticket)) {
                car = carValue;
            }
        }
        return car;
    }

    private Ticket initialTicket(Car car) {
        Ticket ticket = new Ticket();
        ticket.setNumber(rnd.nextInt());
        car.setTicket(ticket);
        return ticket;
    }

    public Ticket searchFreeSpaceForLightCar(Car car) {
        Ticket ticket = null;
        if (lightCar.length > 0) {
            for (int i = 0; i < lightCar.length; i++) {
                if (lightCar[i] == null) {
                   ticket = initialTicket(car);
                    lightCar[i] = car;
                    break;
                }
            }
        }
        return ticket;
    }

    public Ticket searchFreeSpaceForTruck(Car car) {
        Ticket ticket = null;
        for (int i = 0; i < truck.length; i++) {
            if (truck[i] == null) {
               ticket = initialTicket(car);
                truck[i] = car;
                break;
            }
        }
        return ticket;
    }

    @Override
    public Ticket add(Car car) {
        Ticket ticket = null;
        int countFree = 0;
        if (car.size == 1) {
            ticket  = searchFreeSpaceForLightCar(car);
        }
        if (car.size > 1) {
            if (truck.length > 0) {
                ticket = searchFreeSpaceForTruck(car);
            }
            if (ticket == null || truck.length <= 0) {
                for (Car value : lightCar) {
                    if (value == null) {
                        countFree++;
                    }
                }
                if (countFree >= car.size) {
                    int j = 0;
                    while (j < car.size) {
                        searchFreeSpaceForLightCar(car);
                        j++;
                    }
                }
            }
        }
        return car.getTicket();
    }

    private List<Car> mergePark() {
        Car[] mergeCar = new Car[lightCar.length + truck.length];
        int lastTaken = 0;
        for (int i = 0; i < lightCar.length; i++) {
            mergeCar[i] = lightCar[i];
            lastTaken++;
        }
        for (Car car : truck) {
            mergeCar[lastTaken] = car;
            lastTaken++;
        }
        cars.addAll(Arrays.asList(mergeCar));
        return cars;
    }
}