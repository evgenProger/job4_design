package ru.job4j.generics;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SimpleArrayTest {

    @Test
    public void whenAddThenGet() {
        SimpleArray<String> array = new SimpleArray<String>();
        array.add("first");
        String rs = array.get(0);
        assertThat(rs, is("first"));
    }
    @Test
    public void whenRemove() {
        SimpleArray<String> array = new SimpleArray<String>();
        array.add("first");
        array.add("second");
        array.add("third");
        array.remove(1);
        String rs = array.get(1);
        assertThat(rs, is("third"));
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetEmpty() {
        SimpleArray<String> array = new SimpleArray<String>();
        array.get(0);
    }
    @Test
    public void whenAddThenIt() {
        SimpleArray<String> array = new SimpleArray<String>();
        array.add("first");
        String rs = array.iterator().next();
        assertThat(rs, is("first"));
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetOutBound() {
        SimpleArray<String> array = new SimpleArray<String>();
        array.add("first");
        array.get(1);
    }
    @Test(expected = NoSuchElementException.class)
    public void whenGetEmptyFromIt() {
        SimpleArray<String> array = new SimpleArray<String>();
        array.iterator().next();
    }
    @Test
    public void whenSet() {
        SimpleArray<String> array = new SimpleArray<String>();
        array.add("first");
        array.add("second");
        array.add("third");
        array.set(1, "fourth");
        String rs = array.get(1);
        assertThat(rs, is("fourth"));
    }

}