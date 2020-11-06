package ru.job4j.generics;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private final T[] element;
    private int size;

    public SimpleArray() {
        int capacity = 10;
        this.element = (T[]) new Object[capacity];
    }

    public void add(T model) {
        element[size] = model;
        size++;

    }

    public void set(int index, T model) {
        Objects.checkIndex(index, size);
        element[index] = model;
    }

    public void remove(int index) {
        Objects.checkIndex(index, size);
        System.arraycopy(element, index + 1, element, index, size - 1);
        size--;
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        return element[index];
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size; }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return element[currentIndex++];
            }
        };
        return it;
    }

    @Override
    public String toString() {
        return "SimpleArray{" +
                "element=" + Arrays.toString(element) +
                '}';
    }
}
