package ru.job4j.collection;

import ru.job4j.generics.store.User;

import java.util.List;
import java.util.Objects;

public class Analize {
    public Info diff(List<User> previous, List<User> changed) {
        User user = new User();
        Info info = new Info();
        return null;

    }
    public static class User {
        int id;
        String name;

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
