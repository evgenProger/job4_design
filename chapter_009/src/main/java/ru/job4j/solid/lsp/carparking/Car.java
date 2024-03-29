package ru.job4j.solid.lsp.carparking;

public abstract class Car implements Parking {

    protected Ticket ticket;
    protected int size;

    public Car(int size) {
        this.size = size;
    }

    @Override
    public abstract Ticket move(ParkingSpaces parkingSpaces);

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Ticket getTicket() {
        return ticket;
    }
}

