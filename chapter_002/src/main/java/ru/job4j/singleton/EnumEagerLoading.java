package ru.job4j.singleton;

import ru.job4j.tracker.Item;

public enum  EnumEagerLoading {
    INSTANCE;

    public Item add(Item model) {
        return model;
    }

    public static void main(String[] args) {
        EnumEagerLoading tracker =  EnumEagerLoading.INSTANCE;
    }
}
