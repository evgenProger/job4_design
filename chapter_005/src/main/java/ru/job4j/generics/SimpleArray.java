package ru.job4j.generics;

import java.util.Iterator;

public class SimpleArray<T> implements Iterable<T> {
    transient T[] element;
    private int size;
    private int index;

    public SimpleArray() {
        int capacity = 10;
        element = (T[]) new Object[capacity];
    }

    public SimpleArray(T[] element) {
        this.element = element;
        index++;
    }

    public void add(T model) {
        element[index] = model;
        index++;

    }

    public void set(int index, T model) {

    }


    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
