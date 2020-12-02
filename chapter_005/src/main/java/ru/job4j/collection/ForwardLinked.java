package ru.job4j.collection;
import  java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;
    private int size;

    public void add(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            size++;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
        size++;
    }
    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        T value = head.value;
        head = head.next;
        size--;
        return value;
    }

    public T deleteLast() {
        if(head == null) {
            throw new NoSuchElementException();
        }
        Node<T> node = head;
        Node<T> preLast = node;
        while (node.next != null) {
            preLast = node;
            node = node.next;
        }
        T value = node.value;
        node.value = null;
        preLast.next = null;
        size--;
        return value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void revert() {
       Node<T> prev = null;
       Node<T> current = head;
       Node<T> next = head.next;
       while (next != null) {
           current.next = prev;
           prev = current;
           current = next;
           next = next.next;
       }
        current.next = prev;
        head = current;
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }
}
