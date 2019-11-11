package ru.job4j.tracker;

import java.util.function.Consumer;

public class ExitAction extends BaseAction {
    private boolean call = false;

    public ExitAction(int key) {
        super(key, "Exit");
    }
    @Override
    public boolean execute(Input input, Tracker tracker, Consumer<String> output) {
        call = true;
        return false;
    }
    public boolean isCall() {
        return call;
    }
}
