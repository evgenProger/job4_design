package ru.job4j.collection;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleSetTest {
    @Test
    public void whenAdd() {
        SimpleSet<String> array = new SimpleSet<>();
        assertTrue(array.add("first000"));
    }

    @Test
    public void whenAddDubllicate() {
        SimpleSet<String> array = new SimpleSet<>();
        array.add("first");
        array.add("two");
        boolean res =  array.add("first");
        assertThat(res, is(false));
    }

    @Test
    public void whenAddNullThenTrue() {
        SimpleSet<String> array = new SimpleSet<>();
        assertTrue(array.add(null));
    }

}