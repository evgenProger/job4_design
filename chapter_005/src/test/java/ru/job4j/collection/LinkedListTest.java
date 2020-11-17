package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class LinkedListTest {
    @Test
    public void whenAddThenGet() {
        LinkedList<String> list = new LinkedList<>();
        list.add("first");
        String rs1 = list.get(0);
        assertThat(rs1, is("first"));
    }
    @Test
    public void whenAddSomeElementsThenGet() {
        LinkedList<String> list = new LinkedList<>();
        list.add("first");
        list.add("two");
        list.add("three");
        list.add("four");
        String rs1 = list.get(2);
        assertThat(rs1, is("three"));
    }


}