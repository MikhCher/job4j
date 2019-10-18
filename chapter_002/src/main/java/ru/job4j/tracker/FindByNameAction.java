package ru.job4j.tracker;

import java.util.List;

public class FindByNameAction extends BaseAction {
    private boolean call = false;

    public FindByNameAction(int key) {
        super(key, "Find items by name");
    }
    @Override
    public boolean execute(Input input, Tracker tracker) {
        call = true;
        if (tracker.findAll().isEmpty()) {
            System.out.println("There are no any items. You should create at least one item.");
            return true;
        }
        List<Item> array = tracker.findByName(input.askStr("Enter name: "));
        if (!array.isEmpty()) {
            for (Item item : array) {
                System.out.println("#" + item.getId() + ", " + item.getName());
            }
        } else {
            System.out.println("There is no items with this name");
        }
        return true;
    }
    public boolean isCall() {
        return call;
    }
}
