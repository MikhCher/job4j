package ru.job4j.singleton;

import ru.job4j.tracker.Item;

public class StaticFieldLazy {
    private static StaticFieldLazy instance;

    private StaticFieldLazy() {
    }

    public static StaticFieldLazy getInstance() {
        if (instance == null) {
            instance = new StaticFieldLazy();
        }
        return  instance;
    }

    public Item add(Item model) {
        return model;
    }

    public static void main(String[] args) {
        StaticFieldLazy tracker = StaticFieldLazy.getInstance();
    }
}
