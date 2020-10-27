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
        if (cursor == null && data.hasNext()) {
            cursor = data.next();
        }
        if (cursor == null) {
            return false;
        }
        if (cursor.hasNext()) {
            return true;
        }
        if (data.hasNext()) {
            cursor = data.next();
        }
        return cursor.hasNext();
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        if (!cursor.hasNext() && data.hasNext()) {
            cursor = data.next();
        }

        return cursor.next();

    }
}
