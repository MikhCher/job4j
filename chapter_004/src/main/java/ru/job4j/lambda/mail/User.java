package ru.job4j.lambda.mail;

import java.util.Objects;

public class User implements Comparable<User> {
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(getName(), user.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(User o) {
        return this.name.compareTo(o.name);
    }
}
