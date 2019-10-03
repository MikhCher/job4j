package ru.job4j.tracker;

public interface UserActions {
    int key();
    String info();
    boolean execute(Input input, Tracker tracker);
}
