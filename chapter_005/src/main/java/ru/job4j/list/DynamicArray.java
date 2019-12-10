package ru.job4j.list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

public class DynamicArray<E> implements Iterable<E> {
    private Object[] container;
    private int freePosition = 0;
    private boolean hasMode = false;

    public DynamicArray(int size) {
        container = new Object[size];
    }

    public void add(E value) {
        if (container.length == freePosition) {
            grow();
        }
        container[freePosition++] = value;
        hasMode = true;
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
        hasMode = false;
        return new Iterator<E>() {
            private int cursor = 0;

            @Override
            public boolean hasNext() {
                return cursor < container.length && cursor < freePosition;
            }

            @Override
            public E next() {
                if (hasMode) {
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
