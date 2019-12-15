package ru.job4j.set;

import ru.job4j.list.DynamicArray;

import java.util.Iterator;

public class SimpleSet<T> implements Iterable<T> {
    private DynamicArray<T> list = new DynamicArray<>(10);

    public void add(T value) {
        if (!contains(value)) {
            list.add(value);
        }
    }

    private boolean contains(T value) {
        boolean result = false;
        for (T data : list) {
            if (data == value) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}
