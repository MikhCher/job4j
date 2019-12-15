package ru.job4j.list;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SimpleQueueTest {
    private SimpleQueue<Integer> queue = new SimpleQueue<>();

    @Test(expected = NoSuchElementException.class)
    public void whenPushThreeElementsThenPollFour() {
        queue.push(1);
        queue.push(2);
        queue.push(3);
        assertThat(queue.poll(), is(1));
        assertThat(queue.poll(), is(2));
        assertThat(queue.poll(), is(3));
        queue.poll();
    }

    @Test(expected = NoSuchElementException.class)
    public void whenQueueIsEmptyThenThrowException() {
        queue.poll();
    }
}