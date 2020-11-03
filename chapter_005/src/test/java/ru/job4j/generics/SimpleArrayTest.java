package ru.job4j.generics;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SimpleArrayTest {
    @Test
    public void whenAddThenGet() {
        String[] str = new String[10];
        SimpleArray<String> array = new SimpleArray<>(str);
        array.add("first");
        assertThat("first", is("first"));
    }

}