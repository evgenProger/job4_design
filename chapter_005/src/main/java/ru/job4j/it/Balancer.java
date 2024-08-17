package ru.job4j.it;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Balancer {
    public static void split(List<ArrayList<Integer>> nodes, Iterator<Integer> source) {
        CyclicIterator<ArrayList<Integer>> cyclicIterator = new CyclicIterator<>(nodes);
        int count = 0;
        while (source.hasNext()) {
            int number = source.next();
            nodes.get(count).add(number);
            count += 1;
            if (count == nodes.size()) {
                count = 0;
            }
        }
    }
}
