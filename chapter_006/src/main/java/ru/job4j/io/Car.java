package ru.job4j.io;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

public class Car {
    private boolean res;
    private int number;
    private String name;
    private Person person;
    private int[] years;

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

    public boolean isRes() {
        return res;
    }

    public void setRes(boolean res) {
        this.res = res;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int[] getYears() {
        return years;
    }

    public void setYears(int[] years) {
        this.years = years;
    }

    private static class Person {
        private String id = "1245";
        public Person(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
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
