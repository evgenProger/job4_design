package ru.job4j.collection;
import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<T> implements Iterable<T> {
    private SimpleArray<T> array = new SimpleArray<T>();

    public SimpleArray<T> getArray() {
        return array;
    }

    public  void add(T value) {
        if (dublicate(value)) {
            array.add(value);
        }
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

    public T get(int index) {
        return array.get(index) ;
    }

    @Override
    public Iterator<T> iterator() {
        return array.iterator();
    }
}
