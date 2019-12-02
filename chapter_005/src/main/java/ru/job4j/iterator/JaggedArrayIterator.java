package ru.job4j.iterator;

import java.util.Iterator;

public class JaggedArrayIterator implements Iterator<Integer> {
    private final int[][] values;
    private int pointer = 0;

    public JaggedArrayIterator(final int[][] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        int count = 0;
        for (int index = 0; index < values.length; index++) {
            count += values[index].length;
        }
        return count > pointer;
    }

    @Override
    public Integer next() {
        int row = 0;
        int rowSize = values[row].length - 1;
        int count = values[row].length;
        while (pointer - count >= rowSize) {
            row++;
            count += values[row].length;
        }
        int rowPointer = pointer;
        for (int index = 0; index < row; index++) {
            rowPointer -= values[index].length;
        }
        pointer++;
        return values[row][rowPointer];
    }
}
    