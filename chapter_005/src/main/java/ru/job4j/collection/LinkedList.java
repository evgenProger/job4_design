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
        int i = 0;
        Node<E> result;
        if (index > size / 2) {
            result = last.prev;
            while (result != null) {
                result = last.prev;
                i++;
                if (i == index) {
                    break;
                }

            }
        }
        else {
            result = first.next;
            while (result != null) {
                result = first.next;
                i++;
                if(i == index) {
                    break;
                }
            }
        }
        return (E) result;
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
                return next();
            }
        };
        return it;
    }
}
