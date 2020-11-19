package ru.job4j.collection;

public class SimpleStack<T> {
    ForwardLinked<T> linked = new ForwardLinked<T>();
    private Node<T> head;

    public void push(T value) {
        head = new Node(value, head);
    }

    public T pop() {
        T result = head.value;
        head = head.next;
        return result;
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

}
