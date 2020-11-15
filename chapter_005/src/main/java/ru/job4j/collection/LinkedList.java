package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class LinkedList<E> implements Iterable<E> {
    private   E[] elements;
    private int size;
    private Node<E> first;
    private Node<E> last;
    private int modCount;

    public LinkedList() {
        int capacity = 10;
        this.elements = (E[]) new Object[capacity];
    }

    public void add(E value) {
        final Node<E> l = last;
        final Node<E> newMode = new Node<>(first, value, l);
        last = newMode;
        if (l == null) {
            first = newMode;
        }
         else {
            l.next = newMode;
        }
        elements[size] = (E) newMode;
        size++;
        modCount++;
    }
    public E get(int index) {
        Objects.checkIndex(index, size);
        return elements[index];
    }

    private static class Node<E> {
        E value;
        Node<E> next;
        Node<E> prev;

        public Node(Node<E> prev, E value, Node<E> next) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> it = new Iterator<E>() {
            private int expectCount = modCount;
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return elements[currentIndex++];
            }
        };
        return it;
    }
}
