package ru.job4j.tracker;

import java.util.function.Consumer;

public class CreateAction extends BaseAction {
    private boolean call = false;

    protected CreateAction(int key) {
        super(key, "Create item");
    }

    @Override
    public boolean execute(Input input, Tracker tracker, Consumer<String> output) {
        call = true;
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        return true;
    }
    public boolean isCall() {
        return call;
    }
}