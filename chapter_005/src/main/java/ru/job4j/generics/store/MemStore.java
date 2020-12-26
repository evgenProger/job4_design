package ru.job4j.generics.store;

import ru.job4j.generics.store.Base;
import ru.job4j.generics.store.Store;

import java.util.ArrayList;
import java.util.List;

public final class MemStore<T extends Base> implements Store<T> {

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
                mem.set(i, (T) model);
                result = true;
                break;
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
                break;
            }
        }
        return result;
    }

    @Override
    public T findById(String id) {
        T base = null;
        for (T b: mem) {
            if (b.getId().equals(id)) {
                base = b;
                break;
            }
        }
        return base;
    }
}
