package ru.job4j.map;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class HashMapTest {
    HashMap map = new HashMap();

    @Test
    public void whenInsertSomeNodesArrayWillGrowAndEverythingTrue() {
        assertTrue(map.insert(1, "value"));
        assertTrue(map.insert(2, "value"));
        assertTrue(map.insert(3, "value"));
        assertThat(map.get(1), is("value"));
    }

    @Test
    public void whenAddTwoSimilarKeysThenFalse() {
        assertTrue(map.insert(1, "value"));
        assertFalse(map.insert(1, "value"));
    }

    @Test
    public void whenGetByKey() {
        assertTrue(map.insert(1, "value"));
        assertThat(map.get(1), is("value"));
    }

    @Test
    public void whenDeleteByKey() {
        assertTrue(map.insert(1, "value"));
        assertTrue(map.delete(1));
        assertTrue(map.insert(1, "value"));
    }

    @Test (expected = NullPointerException.class)
    public void whenGetKeyWhichNotExistsThenNPE() {
        assertNotNull(map.get(1));
    }

    @Test
    public void whenInsertNullKeyThenGetItsValue() {
        assertTrue(map.insert(null, "value"));
        assertThat(map.get(null), is("value"));
    }
}