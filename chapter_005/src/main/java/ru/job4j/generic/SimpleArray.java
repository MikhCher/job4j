package ru.job4j.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable<T> {
    private final int SIZE;
    private Object[] array;
    private int freePosition = 0;

    public SimpleArray(final int SIZE) {
        this.SIZE = SIZE;
        this.array = new Object[SIZE];
    }

    public void add(T model) {
        array[freePosition++] = model;
    }

    public void set(int index, T model) {
        if (freePosition <= index) {
            throw new ArrayIndexOutOfBoundsException();
        }
        array[index] = model;
        freePosition++;
    }

    public void remove(int index) {
        if (freePosition <= index) {
            throw new ArrayIndexOutOfBoundsException();
        }
        System.arraycopy(array, index + 1, array, index, SIZE - index - 1);
        freePosition--;
    }

    public T get(int index) {
        if (freePosition <= index) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return (T) array[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int pointer = 0;

            @Override
            public boolean hasNext() {
                return pointer < SIZE && pointer < freePosition;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) array[pointer++];
            }
        };
    }
}
