package ru.job4j.list;

public class SimpleStack<T> {
    private SimpleArrayList<T> list = new SimpleArrayList<>();
    private int size = 0;

    public T poll() {
        this.size--;
        return list.delete();
    }

    public void push(T value) {
        list.add(value);
        this.size++;
    }

    public int getSize() {
        return this.size;
    }
}
