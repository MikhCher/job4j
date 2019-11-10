package ru.job4j.tracker;

import java.util.function.Consumer;

public class FindByIDAction extends BaseAction {
    private boolean call = false;

    public FindByIDAction(int key) {
        super(key, "Find item by ID");
    }
    @Override
    public boolean execute(Input input, Tracker tracker, Consumer<String> output) {
        call = true;
        if (tracker.findAll().isEmpty()) {
            output.accept("There are no any items. You should create at least one item.");
            return true;
        }
        String id = input.askStr("Enter ID: ");
        Item item = tracker.findById(id);
        if (item != null) {
            output.accept("#" + item.getId() + ", " + item.getName());
        } else {
            output.accept("There is no item with this id");
        }
        return true;
    }
    public boolean isCall() {
        return call;
    }
}
