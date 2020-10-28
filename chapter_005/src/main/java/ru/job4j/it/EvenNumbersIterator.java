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
        boolean flag;
        while (point + 1 != result.length && result[point + 1] % 2 != 0) {
            point++;
        }
        if (point + 1 == result.length) {
            flag = result[point] % 2 == 0;
        }
        else {
            flag = result[point + 1] % 2 == 0;
        }

        return flag;
    }

    @Override
    public Integer next() {
        if (result[point] % 2 == 0) {
            return result[point++];
        }
        if (hasNext()) {
            point++;
        } else {
            throw new NoSuchElementException();
        }


        return result[point++];

    }
}
