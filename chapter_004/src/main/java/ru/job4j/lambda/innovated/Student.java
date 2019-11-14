package ru.job4j.lambda.innovated;

public class Student implements Comparable<Student> {
    private String name;
    private int scope;

    public Student(String name, int scope) {
        this.name = name;
        this.scope = scope;
    }

    public Student() {
    }

    public int getScope() {
        return scope;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(this.scope, o.scope) * -1;
    }
}
