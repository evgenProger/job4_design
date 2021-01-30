package ru.job4j.collection;

import ru.job4j.generics.store.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Analyze {
    public Info diff(List<User> previous, List<User> changed) {
        Map<Integer, String> innovated;
        Info info = new Info();
        info.added = changed.size() - previous.size();
        info.deleted = previous.size() - changed.size();
        innovated = previous.stream().collect(Collectors.toMap(u -> u.id, u -> u.name));
        info.changed = (int) changed.stream().filter(user -> !user.name.equals(innovated.get(user.id))).map(t -> 1).count();
         // info.changed = users.size();
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
