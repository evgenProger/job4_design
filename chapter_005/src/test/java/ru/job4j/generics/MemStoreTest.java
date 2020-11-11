package ru.job4j.generics;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MemStoreTest {
    @Test
    public void whenAdd() {
        User user = new User("3456");
        UserStore userStore = new UserStore();
        userStore.add(user);
        assertThat(userStore.findById("3456").getId(), is("3456"));
    }

    @Test
    public void whenReplaceThenReturnNewUser() {
        User user1 = new User("3456");
        User user2 = new User("3457");
        User user3 = new User("3458");
        UserStore userStore = new UserStore();
        userStore.add(user1);
        userStore.add(user2);
        userStore.replace(userStore.findById(user1.getId()).getId(), user3);
        assertThat(userStore.findById(user3.getId()).getId(), is("3458"));
    }

    @Test
    public void whenDeleteThenReturnTrue() {
        User user1 = new User("3456");
        User user2 = new User("3457");
        UserStore userStore = new UserStore();
        userStore.add(user1);
        userStore.add(user2);
        assertTrue(userStore.delete(user1.getId()));
    }

    @Test
    public void whenFindId() {
        User user1 = new User("3456");
        User user2 = new User("3457");
        UserStore userStore = new UserStore();
        userStore.add(user1);
        userStore.add(user2);
        assertThat(userStore.findById("3456"), is(user1));

    }
}