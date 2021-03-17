package ru.job4j.io.serialization;

public class Person {
    private String id;
    private int number;
    public Person(String id, int number) {
        this.id = id;
        this.number = number;
    }

    public String getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }
}
