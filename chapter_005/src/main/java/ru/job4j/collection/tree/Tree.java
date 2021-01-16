package ru.job4j.collection.tree;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;
import java.util.function.Predicate;

public class Tree<E> implements SimpleTree<E> {
    private final Node<E> root;
    private Predicate<E> predicate;

    public Tree(final E root ) {
        this.root = new Node<E>(root);
    }

    @Override
    public boolean added(E parent, E child) {
        boolean rs = false;
        Optional<Node<E>> current = this.findBy(parent);
        if (current.isPresent() && findBy(child).isEmpty()) {
            current.get().children.add(new Node<>(child));
            rs = true;
        }
        return rs;
    }

    public boolean findByPredicate(Predicate<E> predicate, E value) {
        boolean rs = false;
        Node<E> current;
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(root);
        while (!data.isEmpty()) {
            current = data.poll();
            if (predicate.test(value))) {
                rs = true;
                break;
            }
            data.addAll(current.children);
        }
        return rs;
    }

    public boolean isBinary() {
        boolean rs = true;
        Predicate<Integer> pre = p -> p > 2;
        Node<E> current = root;
        Queue<Node<E>> data = new LinkedList<>();
        if (current.children.size() > 2) {
            return false;
        }
        data.addAll(current.children);
        /* while (!data.isEmpty()) {
            current = data.poll();
            if (current.children.size() > 2) {
                rs = false;
                break;
            }
            data.addAll(current.children);
        }
       */ if (findByPredicate(pre, current.children.size()) {
           rs = false;
        }
        return rs;
    }
    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rs1 = Optional.empty();
        Node<E> current;
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            current = data.poll();
            if (current.value.equals(value)) {
                rs1 = Optional.of(current);
                break;
            }
            data.addAll(current.children);
        }
        return rs1;
    }
}
