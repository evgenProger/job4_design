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
            result = last;
            while (result.prev != null) {
                result = last.prev;
                i++;
                if (i == index) {
                    break;
                }
            }
        }
        else {
            result = first;
            while (result.next != null) {
                result = first.next;
                i++;
                if(i == index) {
                    break;
                }
            }
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
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                E value = current.value;
                current = current.next;
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectCount != modCount) {
                    throw new ConcurrentModificationException();
                }

                return value;
            }
        };
        return it;
    }
}
