package ru.job4j.collection;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleSetTest {
    @Test
    public void whenAddThenGet() {
        SimpleSet<String> array = new SimpleSet<>();
        array.add("first");
        String rs1 = array.get(0);
        assertThat(rs1, is("first"));
    }

    @Test
    public void whenAddDublicate() {
        SimpleSet<String> array = new SimpleSet<>();
        array.add("first");
        array.add("two");
        array.add("first");
        assertThat(2, Is.is(array.getArray().getSize()));
    }
}