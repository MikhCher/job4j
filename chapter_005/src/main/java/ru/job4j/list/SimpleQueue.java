package ru.job4j.list;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private SimpleStack<T> stack = new SimpleStack<>();
    private SimpleStack<T> reversedStack = new SimpleStack<>();

    public T poll() {
        int size = stack.getSize() + reversedStack.getSize();
        if (size == 0) {
            throw new NoSuchElementException();
        }
        if (reversedStack.getSize() == 0) {
            for (int index = 0; index < size; index++) {
                reversedStack.push(stack.poll());
            }
        }
        return reversedStack.poll();
    }

    public void push(T value) {
        stack.push(value);
    }
}