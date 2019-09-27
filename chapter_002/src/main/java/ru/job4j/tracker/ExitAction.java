package ru.job4j.tracker;

public class ExitAction implements UserActions {
    private boolean call = false;

    @Override
    public String name() {
        return "Exit";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        call = true;
        return false;
    }
    public boolean isCall() {
        return call;
    }
}
