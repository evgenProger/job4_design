package ru.job4j.generics;

import java.util.ArrayList;
import java.util.List;

public final class MemStore<T extends Base> implements Store {

    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(Base model) {

    }

    @Override
    public boolean replace(String id, Base model) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public Base findById(String id) {
        return null;
    }
}
