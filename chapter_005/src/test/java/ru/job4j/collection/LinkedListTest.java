package ru.job4j.collection;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class LinkedListTest {
    @Test
    public void whenAddThenGet() {
        LinkedList<String> list = new LinkedList<String>();
        list.add("first");
        String rs1 = list.get(0);
        assertThat(rs1, is("first"));
    }

    @Test
    public void whenAddSomeElementsThenGet() {
        LinkedList<String> list = new LinkedList<String>();
        list.add("first");
        list.add("two");
        list.add("three");
        list.add("four");
        String rs1 = list.get(1);
        assertThat(rs1, is("two"));
    }

    @Test
    public void whenAddThenIterator() {
        LinkedList<String> array = new LinkedList<String>();
        array.add("first");
        String rs1 = array.iterator().next();
        assertThat(rs1, is("first"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetEmpty() {
        LinkedList<String> array = new LinkedList<String>();
        array.get(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetOutOfBoundsException() {
        LinkedList<String> array = new LinkedList<String>();
        array.add("first");
        array.get(1);
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetEmptyFromIt() {
        LinkedList<String> array = new LinkedList<String>();
        array.iterator().next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCorruptedIt() {
        LinkedList<String> array = new LinkedList<String>();
        array.add("first");
        Iterator<String> it = array.iterator();
        array.add("second");
        it.next();
    }
}