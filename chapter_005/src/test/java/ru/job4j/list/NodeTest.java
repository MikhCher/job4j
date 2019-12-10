package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NodeTest {
    private Node<Integer> first;
    private Node<Integer> second;
    private Node<Integer> third;
    private Node<Integer> fourth;
    private Node<Integer> test;

    @Before
    public void setUp() {
        test = new Node<>(null);
        first = new Node<>(1);
        second = new Node<>(2);
        third = new Node<>(3);
        fourth = new Node<>(4);
    }

    @Test
    public void whenThereAre4NodesAndLastOneRefersToFirst() {
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = first;
        assertTrue(test.hasCycle(first));
    }

    @Test
    public void whenThereAre4NodesAndTheThirdRefersToSecond() {
        first.next = second;
        second.next = third;
        third.next = second;
        fourth.next = null;
        assertTrue(test.hasCycle(first));
    }

    @Test
    public void whenThereAre4NodesAndTheyAreNotCycled() {
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = null;
        assertFalse(test.hasCycle(first));
    }

    @Test
    public void whenThereAreNoAnyNodes() {
        assertFalse(test.hasCycle(test));
    }
}