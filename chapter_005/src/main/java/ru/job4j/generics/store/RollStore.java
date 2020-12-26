package ru.job4j.generics.store;

public class RollStore implements Store<Roll> {
    private final Store<Roll> store = new MemStore<>();

    @Override
    public void add(Roll model) {
        store.add(model);
    }

    @Override
    public boolean replace(String id, Roll model) {
        return store.replace(id, model);
    }

    @Override
    public boolean delete(String id) {
        return store.delete(id);
    }

    @Override
    public Roll findById(String id) {
        return store.findById(id);
    }
}
