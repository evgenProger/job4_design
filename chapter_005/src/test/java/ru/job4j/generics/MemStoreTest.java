package ru.job4j.generics;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MemStoreTest {
    @Test
    public void whenAdd() {
        List<User> mem = new ArrayList<>();
        User user = new User("3456");
        UserStore userStore = new UserStore();
        mem.add(user);
        assertThat(userStore.findById("3456").getId(), is("3456"));

    }

}