package ru.job4j.solid.isp.violates.exampleone;

/**
В этом интерфейсе указано, что интеллектуальное устройство может печатать, отправлять факсы и сканировать.
Реализацией этого интерфейса может быть класс AllInPrinter:
 */

public interface ISmartDevice {
    void print();

    void fax() throws NoSuchMethodException;

    void scan() throws NoSuchMethodException;
}
