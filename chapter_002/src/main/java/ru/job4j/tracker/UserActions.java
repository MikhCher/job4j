package ru.job4j.tracker;

public interface UserActions {
    String name();
    boolean execute(Input input, Tracker tracker);
}
