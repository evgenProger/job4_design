package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class NonNullIterator implements Iterator<Integer> {
    private Integer[] data;
    private int index;

    public NonNullIterator(Integer[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        boolean result = true;
        if (data.length == 0 || index == data.length) {
            return false;
        }
        while (data[index] == null) {
            if (index == data.length - 1) {
                result = false;
                break;
            }
            index++;
        }
        return result;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[index++];
    }

}
