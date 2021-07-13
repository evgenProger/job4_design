package ru.job4j.kiss;

import org.junit.Test;

import java.util.Comparator;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MaxMinTest {
    @Test
    public void whenHasListThenGetMax() {
        MaxMin maxMin = new MaxMin();
        List<Integer> numbers = List.of(2, 5, 4, 15, 9, 1);
        int result = maxMin.max(numbers, Comparator.comparingInt(integer -> integer));
        assertThat(result, is(15));

    }

    @Test
    public void whenHasListThenGetMin() {
        MaxMin maxMin = new MaxMin();
        List<Integer> numbers = List.of(2, 5, 4, 15, 9, 1);
        int result = maxMin.min(numbers, Comparator.comparingInt(integer -> integer));
        assertThat(result, is(1));
    }

    @Test
    public void whenListSizeOneThenGetValue() {
        MaxMin maxMin = new MaxMin();
        List<Integer> numbers = List.of(4);
        int result = maxMin.min(numbers, Comparator.comparingInt(integer -> integer));
        assertThat(result, is(4));
    }
}