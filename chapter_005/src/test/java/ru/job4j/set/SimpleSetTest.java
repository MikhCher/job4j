package ru.job4j.set;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SimpleSetTest {
    private SimpleSet<Integer> set = new SimpleSet<>();

    @Test
    public void whenAddThreeDifferentElementThenGetSameThree() {
        set.add(1);
        set.add(2);
        set.add(3);
        Iterator<Integer> iterator = set.iterator();
        assertThat(iterator.next(), is(1));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.next(), is(3));
    }

    @Test
    public void whenAddSameElements() {
        set.add(1);
        set.add(1);
        Iterator<Integer> iterator = set.iterator();
        assertThat(iterator.next(), is(1));
        assertFalse(iterator.hasNext());
    }
}