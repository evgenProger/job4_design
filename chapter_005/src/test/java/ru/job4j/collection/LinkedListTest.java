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

}