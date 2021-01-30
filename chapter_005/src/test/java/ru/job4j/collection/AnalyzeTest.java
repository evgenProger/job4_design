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
        Analyze.Info info;
        Analyze analyze = new Analyze();
        info = analyze.diff(previous, changed);
        int res = info.added;
        assertThat(res, is(1));
    }
    @Test
    public void whenChangedThenNewList() {
        Analyze.Info info;
        Analyze analyze = new Analyze();
        previous.add(new Analyze.User(27, "Mike"));
        changed.set(0, new Analyze.User(25, "Bob"));
        changed.set(1, new Analyze.User(26, "Kate"));
        info = analyze.diff(previous, changed);
        assertThat(info.changed, is(2));
    }
}