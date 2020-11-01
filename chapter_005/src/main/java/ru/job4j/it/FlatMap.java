package ru.job4j.it;

import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class FlatMap<T> implements Iterator {
    private final Iterator<Iterator<T>> data;
    private Iterator<T> cursor = Collections.emptyIterator();

    public FlatMap(Iterator<Iterator<T>> data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        while (!cursor.hasNext() && data.hasNext()) {
            cursor = data.next();
        }
        return cursor.hasNext();
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return cursor.next();
    }
}
