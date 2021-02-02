package ru.job4j.collection;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.generics.store.User;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AnalyzeTest {
     private List<Analyze.User> previous = new ArrayList();
    private List<Analyze.User> changed = new ArrayList<>();

    @Before
    public void initLists() {
        previous.add(new Analyze.User(25, "Evgeny"));
        previous.add(new Analyze.User(26, "Vika"));
        changed.addAll(previous);
    }

    @Test
    public void whenAddThenNewSize() {
        changed.add(new Analyze.User(27, "Bob"));
        changed.add(new Analyze.User(28, "Kate"));
        changed.add(new Analyze.User(30, "Mark"));
        Analyze.Info info;
        Analyze analyze = new Analyze();
        info = analyze.diff(previous, changed);
        int res = info.added;
        assertThat(res, is(3));
    }
    @Test
    public void whenChangedThenNewList() {
        Analyze.Info info;
        Analyze analyze = new Analyze();
        changed.set(0, new Analyze.User(25, "Masha"));
        changed.set(1, new Analyze.User(26, "Margo"));
        info = analyze.diff(previous, changed);
        assertThat(info.changed, is(2));
    }
    @Test
    public void whenDeletedThenNewList() {
        Analyze.Info info;
        Analyze analyze = new Analyze();
        previous.add(new Analyze.User(27, "Mike"));
        previous.add(new Analyze.User(32, "Roma"));
        changed.add(new Analyze.User(27, "Mike"));
        changed.add(new Analyze.User(32, "Roma"));
        changed.remove(0);
        changed.remove(0);
        changed.remove(0);
        info = analyze.diff(previous, changed);
        assertThat(info.deleted, is(3));
    }
}