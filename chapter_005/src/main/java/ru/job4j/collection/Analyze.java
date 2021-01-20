package ru.job4j.collection;

import ru.job4j.generics.store.User;

import java.util.List;
import java.util.Objects;

public class Analyze {
    public Info diff(List<User> previous, List<User> changed) {
        Info info = new Info();
        info.added = changed.size() - previous.size();
        info.deleted = previous.size() - changed.size();
        for (int i = 0; i < previous.size(); i++) {
            for (int j = 0; j < changed.size(); j++) {
                if (!previous.get(i).name.equals(changed.get(j).name)) {
                    if (previous.get(i).id == changed.get(j).id) {
                        info.changed++;
                    }
                }
            }
        }
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
