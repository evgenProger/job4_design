package ru.job4j.it;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class BalancerTest {

    @Test
    public void whenSingleAndIteratorThree() {
        List<ArrayList<Integer>> nodes = List.of(
                new ArrayList<>()
        );
        Iterator<Integer> source = List.of(1, 2, 3).iterator();
        Balancer.split(nodes, source);
        assertThat(nodes).isEqualTo(
                List.of(
                        List.of(1, 2, 3)
                )
        );
    }

    @Test
    public void whenThreeListsAndIteratorEmpty() {
        List<ArrayList<Integer>> nodes = List.of(
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>()
        );
        Iterator<Integer> source = Collections.emptyIterator();
        Balancer.split(nodes, source);
        assertThat(nodes).containsExactlyInAnyOrder(
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>()
        );
    }

    @Test
    public void whenTwoListsAndIteratorThree() {
        List<ArrayList<Integer>> nodes = List.of(
                new ArrayList<>(),
                new ArrayList<>()
        );
        Iterator<Integer> source = List.of(1, 2, 3).iterator();
        Balancer.split(nodes, source);
        assertThat(nodes).containsExactlyInAnyOrder(
                new ArrayList<>(List.of(1, 3)),
                new ArrayList<>(List.of(2))
        );
    }

    @Test
    public void whenThreeListsAndIteratorThree() {
        List<ArrayList<Integer>> nodes = List.of(
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>()
        );
        Iterator<Integer> source = List.of(1, 2, 3).iterator();
        Balancer.split(nodes, source);
        assertThat(nodes).containsExactlyInAnyOrder(
                new ArrayList<>(List.of(1)),
                new ArrayList<>(List.of(2)),
                new ArrayList<>(List.of(3))
        );
    }

    @Test
    public void whenThreeListsAndIteratorTwo() {
        List<ArrayList<Integer>> nodes = List.of(
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>()
        );
        Iterator<Integer> source = List.of(1, 2).iterator();
        Balancer.split(nodes, source);
        assertThat(nodes).containsExactlyInAnyOrder(
                new ArrayList<>(List.of(1)),
                new ArrayList<>(List.of(2)),
                new ArrayList<>()
        );
    }

    @Test
    public void whenThreeListsAndIteratorFour() {
        List<ArrayList<Integer>> nodes = List.of(
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>()
        );
        Iterator<Integer> source = List.of(1, 2, 3, 4).iterator();
        Balancer.split(nodes, source);
        assertThat(nodes).containsExactlyInAnyOrder(
                new ArrayList<>(List.of(1, 4)),
                new ArrayList<>(List.of(2)),
                new ArrayList<>(List.of(3))
        );
    }
}

