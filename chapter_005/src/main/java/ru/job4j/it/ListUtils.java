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
            if(i.nextIndex() == index + 1) {
                i.add(value);
                break;
            }
            i.next();
        }
    }

    public static <T> List<T> removeIf(List<T> list, Predicate<T> filter) {
        for (T value : list) {
            if (filter.test(value)) {
                list.remove(value);
                break;
            }
        }
        return list;
    }

    public static <T> List<T> replaceIf(List<T> list, Predicate<T> filter, T value) {
        for (T obj: list) {
            if (filter.test(obj)) {
                list.set(list.indexOf(obj), value);
                break;
            }
        }
        return list;
    }
    public static <T> List<T> removeAll(List<T> list, List<T> elements) {
        for (T e: elements) {
            for (T l: list) {
                if (e == l) {
                    list.remove(l);
                    break;
                }
            }
        }
        return list;
    }
 }
