package ru.job4j.kiss;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class MaxMin {
    private <T> T findByMaxMin(List<T> value, Comparator<T> comparator, Predicate<Integer> predicate) {
        T current;
        T variable = null;
        for (int i = 0; i < value.size() - 1; i++) {
            current = value.get(i);
            int result = comparator.compare(value.get(i + 1), current);
            if (predicate.test(result)) {
                variable = value.get(i + 1);
            }
        }
        return variable;
    }

    public <T> T max(List<T> value, Comparator<T> comparator) {
       return findByMaxMin(value, comparator, result -> result > 0);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return findByMaxMin(value, comparator, result -> result < 0);
    }
}
