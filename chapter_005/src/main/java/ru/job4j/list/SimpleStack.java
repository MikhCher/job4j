package ru.job4j.list;

public class SimpleStack<T> {
    private SimpleArrayList<T> list = new SimpleArrayList<>();

    public T poll() {
        return list.delete();
    }

    public void push(T value) {
        list.add(value);
    }
}
