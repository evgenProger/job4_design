package ru.job4j.collection.tree;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TreeTest {
    @Test
    public void when6ElFindLastThen6() {
        Tree<Integer> tree = new Tree<Integer>(1);
        tree.added(1, 2);
        tree.added(1, 3);
        tree.added(1, 4);
        tree.added(4, 5);
        tree.added(5, 6);
        assertThat(
                tree.findBy(6).isPresent(),
                is(true)
        );
    }

    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        Tree<Integer> tree = new Tree<>(1);
        tree.added(1, 2);
        assertThat(
                tree.findBy(7).isPresent(),
                is(false)
        );
    }
}