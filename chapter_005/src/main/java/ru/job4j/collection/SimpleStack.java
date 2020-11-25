package ru.job4j.collection;

public class SimpleStack<T> {
    ForwardLinked<T> linked = new ForwardLinked<T>();

    public void push(T value) {
        Node<T> node = new Node<>(value, null);
        linked.add(node.value);
    }

    public T pop() {
        T result = linked.deleteLast();
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
