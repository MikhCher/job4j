package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class DynamicArrayTest {
    private DynamicArray<Integer> list;

    @Before
    public void setUp() {
        list = new DynamicArray<>(5);
    }

    @Test
    public void whenAddValuesToListThenGetIt() {
        for (int index = 0; index < 5; index++) {
            list.add(index);
        }
        assertThat(list.get(0), is(0));
        assertThat(list.get(1), is(1));
        assertThat(list.get(2), is(2));
        assertThat(list.get(3), is(3));
        assertThat(list.get(4), is(4));
    }

    @Test
    public void whenArrayGrows() {
        DynamicArray<Integer> shortList = new DynamicArray<>(1);
        assertThat(shortList.size(), is(0));
        shortList.add(45);
        assertThat(shortList.size(), is(1));
        shortList.add(49);
        assertThat(shortList.size(), is(2));
    }

    @Test
    public void whenEmptyHasNextShouldFalse() {
        DynamicArray<Integer> list = new DynamicArray<>(5);
        Iterator<Integer> iterator = list.iterator();
        assertFalse(iterator.hasNext());
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenListStructureHasChanged() {
        list.add(0);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            list.add(1);
            iterator.next();
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetIncorrectIndex() {
        list.get(4);
    }

    @Test(expected = NoSuchElementException.class)
    public void whenIteratorHasNoNextElement() {
        Iterator<Integer> iterator = list.iterator();
        iterator.next();
    }
}