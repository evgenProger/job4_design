package ru.job4j.solid.isp.violates.exampleone;

public class AllInOnePrinter implements ISmartDevice {

    @Override
    public void print() {

    }

    @Override
    public void fax() {

    }

    @Override
    public void scan() {

    }

    /*
    Simple, isn't it? Right. Now suppose we need to handle a dumb device (EconomicPrinter class) that can only print.
    We're forced to implement the Whole interface, for example:
     */
}
