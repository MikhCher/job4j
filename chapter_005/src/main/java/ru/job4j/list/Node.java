package ru.job4j.list;

public class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
    }

    public boolean hasCycle(Node<T> first) {
        boolean cycled = false;
        Node<T> turtle = first;
        Node<T> hare = first;
        while (hare != null && hare.next != null) {
            turtle = turtle.next;
            hare = hare.next.next;
            if (turtle == hare) {
                cycled = true;
                break;
            }
        }
        return cycled;
    }
}
