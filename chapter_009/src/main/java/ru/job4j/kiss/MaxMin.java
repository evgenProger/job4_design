package ru.job4j.kiss;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class MaxMin {
    private <T> T findByMaxMin(List<T> value, Comparator<T> comparator, Predicate<Integer> predicate) {
        T variable = value.get(0);
        for (int i = 0; i < value.size(); i++) {
            int result = comparator.compare(value.get(i), variable);
            if (predicate.test(result)) {
                variable = value.get(i);
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
