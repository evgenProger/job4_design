package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class LinkedList<E> implements Iterable<E> {
    private int size;
    private Node<E> first;
    private Node<E> last;
    private int modCount;

    public void add(E value) {
        final Node<E> l = last;
        final Node<E> newMode = new Node<>(l, value, null);
        last = newMode;
        if (l == null) {
            first = newMode;
        } else {
            l.next = newMode;
        }
        size++;
        modCount++;
    }

    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> result = first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.value;
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
            private Node<E> current = first;
            private int expectCount = modCount;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                E value = current.value;
                current = current.next;
                return value;
            }
        };
        return it;
    }
}
