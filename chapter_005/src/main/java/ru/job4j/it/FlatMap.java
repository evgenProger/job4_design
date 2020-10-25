package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class FlatMap<T> implements Iterator {
    private final Iterator<Iterator<T>> data;
    private Iterator<T> cursor;

    public FlatMap(Iterator<Iterator<T>> data) {
        this.data = data;
    }


    @Override
    public boolean hasNext() {

        if (data.hasNext()) {
            return cursor.hasNext();
        }
        return false;


    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return null;

    }
}
