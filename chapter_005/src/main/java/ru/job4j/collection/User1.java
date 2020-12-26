package ru.job4j.collection;

import java.util.*;

public class User1 {
    String name;
    int children;
    Calendar birthday;

    public User1(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }
    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(obj == null || getClass() != obj.getClass()) {
            return false;
        }
        User1 user1 = (User1) obj;
        return children == user1.children
                && Objects.equals(name, user1.name)
                && Objects.equals(birthday, user1.birthday);
    }

    @Override
    public String toString() {
        return "User1{" +
                "name='" + name + '\'' +
                ", children=" + children +
                ", birthday=" + birthday +
                '}';
    }


    public static class Car {
        String color;
        String name;

        public Car(String color, String name) {
            super();
            this.color = color;
            this.name = name;
        }
    }


    public static void main(String[] args) {
        Calendar c1 = new GregorianCalendar(1980, 10, 15);
        Calendar c2 = new GregorianCalendar(1980, 10, 15);
        User1 user1  = new User1("Evgeny", 2, c1);
        User1 user2 = new User1("Evgeny", 2, c2);
        Car car1 = new Car("red", "bmw");
        Car car2 = new Car("black", "mersedes");
        Map<User1, Car> users = new HashMap<>();
        users.put(user1, car1);
        users.put(user2, car2);
        System.out.println(users);
        System.out.println(users.size());

    }
}
