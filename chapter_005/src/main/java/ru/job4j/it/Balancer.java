package ru.job4j.it;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Balancer {
    public static void split(List<ArrayList<Integer>> nodes, Iterator<Integer> source) {
        CyclicIterator<ArrayList<Integer>> cyclicIterator = new CyclicIterator<>(nodes);
        while (source.hasNext()) {
            int number = source.next();
            cyclicIterator.next().add(number);
        }

    }

}
