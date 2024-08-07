package ru.job4j.it;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class CyclicIterator implements Iterator<Integer> {
    private List<Integer> data;
    int index;

    public CyclicIterator(List<Integer> data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        if (index == data.size()) {
            index = 0;
        }
        return index < data.size();
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data.get(index++);
    }
}
