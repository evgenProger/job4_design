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
    @Test
    public void whenTreeIsBinary() {
        Tree<Integer> tree = new Tree<>(1);
        tree.added(1, 10);
        tree.added(1, 20);
        tree.added(10, 30);
        tree.added(10, 40);
        tree.added(20, 50);
        tree.added(20, 60);
        tree.added(50, 700);
        tree.added(50, 800);
        tree.added(60, 900);
        tree.added(60, 950);
        assertTrue(tree.isBinary());
    }

    @Test
    public void whenTreeIsNotBinary() {
        Tree<Integer> tree = new Tree<>(1);
        tree.added(1, 10);
        tree.added(1, 20);
        tree.added(10, 30);
        tree.added(10, 40);
        tree.added(10, 50);
        tree.added(3, 60);
        assertFalse(tree.isBinary());
    }

}