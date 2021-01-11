package ru.job4j.collection.tree;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

public class Tree<E> implements SimpleTree<E> {
    private final Node<E> root;

    public Tree(final E root ) {
        this.root = new Node<E>(root);
    }

    @Override
    public boolean added(E parent, E child) {
        boolean rs = false;
        Optional<Node<E>> current = this.findBy(parent);
        Optional<Node<E>> ch = this.findBy(child);
        if (ch.isEmpty() && current.isPresent()) {
            current.get().children.add(new Node<>(child));
            rs = true;
        }
        return rs;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rs1 = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> e1 = data.poll();
            if (e1.value.equals(value)) {
                rs1 = Optional.of(e1);
                break;
            }
            data.addAll(e1.children);
        }
        return rs1;
    }
}
