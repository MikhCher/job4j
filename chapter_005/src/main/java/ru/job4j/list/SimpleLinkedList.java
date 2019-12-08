package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleLinkedList<E> implements Iterable<E> {
    private int modCount = 0;
    private int size = 0;
    private Node<E> first = new Node<>(null);
    private Node<E> last;

    /**
     * Добавление элемент в конец списка
     * @param value - значение
     */
    public void add(E value) {
        Node<E> newNode = new Node<>(value);
        if (size == 0) {
            first.data = value;
        } else if (size == 1) {
            first.next = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
        size++;
    }

    /**
     * Получение значения списка по заданному индексу
     * @param index - индекс получаемого элемента
     * @return значение по индексу
     * @throws NoSuchElementException если индекс превышает размер списка
     */
    public E get(int index) throws NoSuchElementException {
        if (index > size) {
            throw new NoSuchElementException();
        }
        Node<E> result = first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.data;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int expectedModCount = modCount;
            private int cursor = 0;
            private Node<E> currentNode = first;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return cursor++ < size;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E value = currentNode.data;
                currentNode = currentNode.next;
                return value;
            }
        };
    }

    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
        }
    }
}
