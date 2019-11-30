package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator<Integer> {
    private final int[] values;
    private int pointer = 0;

    public EvenNumbersIterator(final int[] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        boolean result = false;
        while (pointer < values.length) {
            if (values[pointer] % 2 == 0) {
                result = true;
                break;
            }
            pointer++;
        }
        return result;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        } else {
            return values[pointer++];
        }
    }
}
