package ru.job4j.set;

public class User implements Comparable<User> {
    private Integer age;
    private String name;

    User (Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(User o) {
        return this.age.toString().compareTo(o.age.toString());
    }
}
