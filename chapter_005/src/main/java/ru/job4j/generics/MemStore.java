package ru.job4j.generics;

import java.util.ArrayList;
import java.util.List;

public final class MemStore<T extends Base> implements Store {

    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(Base model) {
        mem.add((T) model);
    }

    @Override
    public boolean replace(String id, Base model) {
        boolean result = false;
        for (int  i = 0;  i < mem.size(); i++) {
            if (mem.get(i).getId().equals(id)) {
                mem.add(i, (T) model);
                result = true;
            }
        }
        return result;
    }
    @Override
    public boolean delete(String id) {
        boolean result = false;
        for(int i = 0; i < mem.size(); i++) {
            if (mem.get(i).getId().equals(id)) {
                mem.remove(i);
                result = true;
            }
        }
        return result;
    }

    @Override
    public Base findById(String id) {
        Base base = null;
        for (Base b: mem) {
            if (b.getId().equals(id)) {
                base = b;
                break;
            }
        }
        return base;
    }
}
