package ru.job4j.solid.lsp.carparking;

public class Ticket {

    protected int number;

    public Ticket(int number) {
        this.number = number;
    }


    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
