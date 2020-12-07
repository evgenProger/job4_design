package ru.job4j.it;

import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.function.Predicate;

public class ListUtils {
    public static <T> void addBefore(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> i = list.listIterator();
        while(i.hasNext()) {
            if (i.nextIndex() == index) {
                i.add(value);
                break;
            }
            i.next();
        }

    }
    public static <T> void addAfter(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            if(i.previousIndex() == index) {
                i.add(value);
            }
            i.next();
        }
    }

    public static <T> List<T> removeIf(List<T> list, Predicate<T> filter) {
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            if (filter.test(i.next())) {
                i.remove();
            }
        }
        return list;
    }

    public static <T> List<T> replaceIf(List<T> list, Predicate<T> filter, T value) {
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            if (filter.test(i.next())) {
                i.set(value);
            }
        }
        return list;
    }
    public static <T> List<T> removeAll(List<T> list, List<T> elements) {
        ListIterator<T> i = elements.listIterator();
        ListIterator<T> j = list.listIterator();
        while (i.hasNext()) {
            if (list.contains(i.next())) {
                list.remove(i.next());
            }
        }
      /*  for (T e: elements) {
            for (T l: list) {
                if (e == l) {
                    list.remove(l);
                    break;
                }
            }
        }
       */
        return list;
    }
 }
