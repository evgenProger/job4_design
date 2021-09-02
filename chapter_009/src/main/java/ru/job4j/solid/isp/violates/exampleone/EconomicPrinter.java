package ru.job4j.solid.isp.violates.exampleone;

public class EconomicPrinter implements ISmartDevice{

    @Override
    public void Print() {

        // Yes, I can print
    }

    @Override
    public void Fax()  {
        throw new UnsupportedOperationException();

    }

    @Override
    public void Scan()  {
        throw new UnsupportedOperationException();

    }

    /*
    This is not very good.
    https://dzone.com/articles/solid-principles-by-example-interface-segregation
     */

}
