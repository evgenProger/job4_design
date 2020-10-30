package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator<Integer> {
    private final int[] result;
    private int point = 0;

    public EvenNumbersIterator(int[] result) {
        this.result = result;
    }

    @Override
    public boolean hasNext() {
        while (point < result.length && result[point] % 2 != 0) {
            point++;
        }


        return point < result.length;
    }

    @Override
    public Integer next() {
        if(!hasNext()) {
            throw new NoSuchElementException();
        }
        return result[point++];
    }
}
