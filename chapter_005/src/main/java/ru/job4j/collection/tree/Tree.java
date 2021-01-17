package ru.job4j.collection.tree;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;
import java.util.function.Predicate;

public class Tree<E> implements SimpleTree<E> {
    private final Node<E> root;

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

    public Optional<Node<E>> findByPredicate(Predicate<Node<E>> predicate) {
        Optional<Node<E>> rs1 = Optional.empty();
        Node<E> current;
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(root);
        while (!data.isEmpty()) {
            current = data.poll();
            if (predicate.test(current)) {
                rs1 = Optional.of(current);
                break;
            }
            data.addAll(current.children);
        }
        return rs1;
    }

    public boolean isBinary() {
       return findByPredicate(node -> node.children.size() > 2).isEmpty();
    }
    @Override
    public Optional<Node<E>> findBy(E value) {
        return findByPredicate(node -> node.value.equals(value));
    }
}
