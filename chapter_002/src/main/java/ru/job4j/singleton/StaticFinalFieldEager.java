package ru.job4j.singleton;

import ru.job4j.tracker.Item;

public class StaticFinalFieldEager {
    private static final StaticFinalFieldEager instance = new StaticFinalFieldEager();

    private  StaticFinalFieldEager() {
    }

    public static StaticFinalFieldEager getInstance() {
        return instance;
    }

    public Item add(Item model) {
        return model;
    }

    public static void main(String[] args) {
        StaticFinalFieldEager tracker = StaticFinalFieldEager.getInstance();
    }
}
