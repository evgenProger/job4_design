package ru.job4j.collection;

import java.util.*;

public class SimpleArray<T> implements Iterable<T> {
    private int capacity = 10;
    private T[] container;
    private int size;
    private int modCount = 0;

    public SimpleArray() {
        this.container = (T[]) new Object[capacity];
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        return container[index];
    }
    public void add(T model) {
       modCount++;
       if (size == container.length) {
           container = Arrays.copyOf(container, (int) ((capacity * 1.5) + 1));
       }
       container[size] = model;
       size++;
    }


    @Override
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<T>() {
            int currentIndex = 0;
            int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return container[currentIndex++];
            }
        };
        return it;
    }

    public int getSize() {
        return size;
    }
}
