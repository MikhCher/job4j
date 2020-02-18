package ru.job4j.map;

import java.util.Calendar;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;
        if (name != null ? !name.equals(user.name) : user.name != null
                || children != user.children
                || birthday != null ? !birthday.equals(user.birthday) : user.birthday != null) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return 31 * ((name != null ? name.hashCode() : 0)
                + children
                + (birthday != null ? birthday.hashCode() : 0));
    }
}
