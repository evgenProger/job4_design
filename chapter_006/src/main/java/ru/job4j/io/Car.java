package ru.job4j.io;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

public class Car {
    boolean res;
    int number;
    String name;
    Person person;
    int[] years;

    @Override
    public String toString() {
        return "Car{" +
                "res=" + res +
                ", number=" + number +
                ", name='" + name + '\'' +
                ", person=" + person +
                ", years=" + Arrays.toString(years) +
                '}';
    }

    public Car(boolean res, int number, String name, Person person, int[] years) {
        this.res = res;
        this.number = number;
        this.name = name;
        this.person = person;
        this.years = years;
    }

    private static class Person {
        String id = "1245";

        public Person(String id) {
            this.id = id;
        }
    }

    public static void main(String[] args) {
        final Car car = new Car(true, 254, "BMW", new Person("1245"), new int[] {1980, 1982, 1952});
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(car));
        /* Модифицируем json-строку */
        final String carJson =
                "{"
                        + "\"res\":true,"
                        + "\"number\":35,"
                        + "\"name\": mers,"
                        + "\"person\":"
                        + "{"
                        + "\"id\":\"254\""
                        + "},"
                        + "\"years\":"
                        + "[\"1984\",\"254\"]"
                +"}";

        final Car carMod = gson.fromJson(carJson, Car.class);
        System.out.println(carMod);

    }




    /*
    {
        "res": false,
        "number": 254,
        "name": "BMW",
        "person" {
            "id": "1245"
        },
        "years": ["1980", "1982", "1952"]
    }
     */
}
