package ru.job4j.solid.isp.violates.exampleone;

public class AllInOnePrinter implements ISmartDevice {

    @Override
    public void Print() {

    }

    @Override
    public void Fax() {

    }

    @Override
    public void Scan() {

    }

    /*
    Simple, isn't it? Right. Now suppose we need to handle a dumb device (EconomicPrinter class) that can only print.
    We're forced to implement the Whole interface, for example:
     */
}
