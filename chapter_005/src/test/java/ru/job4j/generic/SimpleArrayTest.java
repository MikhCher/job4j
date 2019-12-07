package ru.job4j.generic;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleArrayTest {
    private SimpleArray<Integer> sa;
    private final int size = 10;

    @Before
    public void setUp() {
        sa = new SimpleArray<Integer>(size);
    }

    @Test
    public void whenAddItemThenGetSameItem() {
        sa.add(1);
        int result = sa.get(0);
        assertThat(result, is(1));
    }

    @Test
    public void whenChangeItemThenGetNewItem() {
        sa.add(1);
        sa.set(0, 5);
        int result = sa.get(0);
        assertThat(result, is(5));
    }

    @Test
    public void whenAddThreeItemsAndDeleteSecondItemThenGetSecondEqualsThird() {
        sa.add(1);
        sa.add(2);
        sa.add(3);
        sa.remove(1);
        int result = sa.get(1);
        assertThat(result, is(3));
    }

    @Test
    public void testNextMethodOfIterator() {
        sa.add(1);
        sa.add(2);
        Iterator<Integer> iter = sa.iterator();
        assertThat(iter.next(), is(1));
        assertThat(iter.next(), is(2));
    }

    @Test
    public void testHasNextMethodOfIterator() {
        sa.add(1);
        sa.add(2);
        Iterator<Integer> iter = sa.iterator();
        assertThat(iter.hasNext(), is(true));
        iter.next();
        assertThat(iter.hasNext(), is(true));
        iter.next();
        assertThat(iter.hasNext(), is(false));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenOverflowedArrayThenGetException() {
        for (int index = 0; index < size; index++) {
            sa.add(index);
        }
        Iterator<Integer> iter = sa.iterator();
        for (int index = 0; index < size + 1; index++) {
            iter.next();
        }
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenTryingToGetNonexistentModel() {
        sa.get(0);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenDeleteNonexistentModel() {
        sa.remove(0);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenSetToIncorrectPosition() {
        sa.set(9, 1);
    }

}