package ru.job4j.solid.dip.violates.example.two;

/*
Let’s take an example of a car rental company booking application, where we need to be able to reserve different
types of cars. We design our application as follows, violating the DIP.
 */

import java.util.List;

public class ReservationApp {

    public List<CompactCar> compactCars;
    public List<LuxuryCar> luxuryCars;


    public ReservationApp(List<CompactCar> compactCars, List<LuxuryCar> luxuryCars) {
        this.compactCars = compactCars;
        this.luxuryCars = luxuryCars;
    }

    public boolean reserveCompact(CompactCar car, Client client) {
        if (!compactCars.contains(car) && client != null) {
            car.reserve(client);
            return true;
        } else {
            System.out.println("The car was not found or is reserved");
            return false;
        }
    }

    public boolean reserveLux(LuxuryCar car, Client client) {
        if (!luxuryCars.contains(car) && client != null) {
            car.reserve(client);
            return true;
        } else {
            System.out.println("The car was not found or is reserved");
            return false;
        }
    }


    public List<CompactCar> getCompactCars() {
        return compactCars;
    }

    public void setCompactCars(List<CompactCar> compactCars) {
        this.compactCars = compactCars;
    }

    public List<LuxuryCar> getLuxuryCars() {
        return luxuryCars;
    }

    public void setLuxuryCars(List<LuxuryCar> luxuryCars) {
        this.luxuryCars = luxuryCars;
    }
}

/**
 * Хорошо. Если бы вы до сих пор обращали внимание, вы бы заметили более одного нарушения SOLID в этом примере.
 * Помимо нарушения DIP, к которому мы немного вернемся, он также нарушает OCP - класс BookingApp не является OCP,
 * поскольку добавление новой категории транспортных средств обязательно приведет к рефакторингу этого класса.
 * Теперь вернемся к DIP. В примере приложения для бронирования класс BookingApp является модулем верхнего уровня,
 * а автомобиль - модулем нижнего уровня. Один из аспектов DIP, который может быть немного сложнее понять, - это то,
 * как компоненты ранжируются от высокого к низкому уровню. Для этого вам нужно подумать с точки зрения домена -
 * каково основное бизнес-использование приложения? По сути, приложение для бронирования автомобилей предназначено
 * в первую очередь для резервирования автомобилей. Таким образом, модуль, который управляет резервированием,
 * логически является компонентом более высокого уровня (более фундаментальным), в то время как специфика того, что
 * резервируется, - это автомобили. Проблема в предыдущем примере кода заключается в том, что он делает компоненты
 * высокого уровня зависимыми от конкретных типов автомобилей. Это не расширяемая, простая в обслуживании конструкция,
 * потому что, если конкретные требования изменятся и будут добавлены новые категории автомобилей, текущие модули
 * потребуют рефакторинга. Чтобы удовлетворить DIP, мы можем провести рефакторинг следующим образом, введя интерфейс,
 * от которого зависят как высокоуровневые, так и низкоуровневые компоненты.
 */