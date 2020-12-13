package ru.job4j.collection;
import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<T> implements Iterable<T> {
    private SimpleArray<T> array = new SimpleArray<T>();

    public  boolean add(T value) {
        boolean res = false;
        if (dublicate(value)) {
            res = true;
            array.add(value);
        }
        return res;
    }
    public boolean dublicate(T value) {
        boolean flag = true;
        for (T t: array) {
            if (Objects.equals(t, value)) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    @Override
    public Iterator<T> iterator() {
        return array.iterator();
    }
}
