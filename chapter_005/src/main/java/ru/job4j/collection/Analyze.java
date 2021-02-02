package ru.job4j.collection;

import ru.job4j.generics.store.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Analyze {
    public Info diff(List<User> previous, List<User> changed) {
        Map<Integer, String> old;
        old = previous.stream().collect(Collectors.toMap(u -> u.id, u -> u.name));
        Info info = new Info();
        info.added = (int) changed.stream().filter(user -> !old.containsKey(user.id)).count();
        int del   = (int) changed.stream().filter(user -> old.containsKey(user.id)).count();
        info.deleted = old.size() - del;
        info.changed = (int) changed.stream().filter(user -> !user.name.equals(old.get(user.id))).count();

        return info;
    }

    public static class User {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return id == user.id && Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }

    public static class Info {
        int added;
        int changed;
        int deleted;
    }
}
