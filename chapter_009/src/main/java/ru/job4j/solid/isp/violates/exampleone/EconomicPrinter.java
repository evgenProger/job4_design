package ru.job4j.solid.isp.violates.exampleone;

public class EconomicPrinter implements ISmartDevice {

    @Override
    public void print() {


    }

    @Override
    public void fax()  {
        throw new UnsupportedOperationException();

    }

    @Override
    public void scan()  {
        throw new UnsupportedOperationException();

    }

    /**
    This is not very good.
    https://dzone.com/articles/solid-principles-by-example-interface-segregation
     */

}
