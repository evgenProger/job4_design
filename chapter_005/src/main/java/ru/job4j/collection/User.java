package ru.job4j.collection;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class User {
    String name;
    int children;
    Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public static class Car {
        String color;
        String name;

        public Car(String color, String name) {
            this.color = color;
            this.name = name;
        }
    }
    public static void main(String[] args) {
        Calendar c1 = new GregorianCalendar(1980, 10, 15);
        Calendar c2 = new GregorianCalendar(1980, 10, 15);
        User user1  = new User("Evgeny", 2, c1);
        User user2 = new User("Evgeny", 2, c2);
        Car car1 = new Car("red", "bmw");
        Car car2 = new Car("black", "mersedes");
        Map<User, Car> users = new HashMap<>();
        users.put(user1, car1);
        users.put(user2, car2);
        System.out.println(users);

    }
}
