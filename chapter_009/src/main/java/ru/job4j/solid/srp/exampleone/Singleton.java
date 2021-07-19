package ru.job4j.solid.srp.exampleone;

/*
Singleton —  помимо своих основных обязанностей класс занимается еще и контролированием количества
своих экземпляров, чем нарушает Single Responsibility Principle.
 */

public class Singleton {
    private static Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
