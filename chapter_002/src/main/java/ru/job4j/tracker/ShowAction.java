package ru.job4j.tracker;

import java.util.List;
import java.util.function.Consumer;

public class ShowAction extends BaseAction {
    private boolean call = false;

    public ShowAction(int key) {
        super(key, "Show all items");
    }

    @Override
    public boolean execute(Input input, Tracker tracker, Consumer<String> output) {
        call = true;
        List<Item> array = tracker.findAll();
        if (array.isEmpty()) {
            output.accept("There are no any items.");
        }
        for (Item item : array) {
            output.accept("#" + item.getId() + ", " + item.getName());
        }
        return true;
    }

    public boolean isCall() {
        return call;
    }
}
