package ru.job4j.tracker;

import java.util.List;

public class ShowAction extends BaseAction {
    private boolean call = false;

    public ShowAction(int key) {
        super(key, "Show all items");
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        call = true;
        List<Item> array = tracker.findAll();
        if (array.isEmpty()) {
            System.out.println("There are no any items.");
        }
        for (Item item : array) {
            System.out.println("#" + item.getId() + ", " + item.getName());
        }
        return true;
    }

    public boolean isCall() {
        return call;
    }
}
