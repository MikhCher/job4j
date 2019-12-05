package ru.job4j.list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

public class DynamicArray<E> implements Iterable<E> {
    private Object[] container;
    private int modCount = 0;
    private int freePosition = 0;

    public DynamicArray(int size) {
        container = new Object[size];
    }

    public void add(E value) {
        if (container.length == freePosition)
            grow();
        container[freePosition++] = value;
        modCount++;
    }

    public E get(int index) {
        if (index > freePosition) {
            throw new NoSuchElementException();
        }
        return (E) container[index];
    }

    public int size() {
        return freePosition;
    }

    private void grow() {
        container = Arrays.copyOf(container, container.length * 2);
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int cursor = 0;
            private final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return cursor < container.length && cursor < freePosition;
            }

            @Override
            public E next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (E) container[cursor++];
            }
        };
    }
}
