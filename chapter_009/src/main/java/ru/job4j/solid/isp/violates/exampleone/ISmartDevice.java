package ru.job4j.solid.isp.violates.exampleone;

public interface ISmartDevice {
    void print();

    void fax() throws NoSuchMethodException;

    void scan() throws NoSuchMethodException;
}
