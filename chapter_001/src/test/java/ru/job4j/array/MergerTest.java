package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MergerTest {
    @Test
    public void merge() {
        Merger arr = new Merger();
        int[] first = new int[]{1, 3, 4, 6, 9, 10, 12, 14, 17, 18};
        int[] second = new int[]{2, 5, 7, 8, 11, 13, 15, 16, 19, 20};
        int[] third = arr.merge(first, second);
        int[] expect = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        assertThat(third, is(expect));
    }
}
