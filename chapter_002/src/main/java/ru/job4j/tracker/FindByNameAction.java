package ru.job4j.tracker;

import java.util.List;
import java.util.function.Consumer;

public class FindByNameAction extends BaseAction {
    private boolean call = false;

    public FindByNameAction(int key) {
        super(key, "Find items by name");
    }
    @Override
    public boolean execute(Input input, Tracker tracker, Consumer<String> output) {
        call = true;
        if (tracker.findAll().isEmpty()) {
            output.accept("There are no any items. You should create at least one item.");
            return true;
        }
        List<Item> array = tracker.findByName(input.askStr("Enter name: "));
        if (!array.isEmpty()) {
            for (Item item : array) {
                output.accept("#" + item.getId() + ", " + item.getName());
            }
        } else {
            output.accept("There is no items with this name");
        }
        return true;
    }
    public boolean isCall() {
        return call;
    }
}
