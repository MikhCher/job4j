package ru.job4j.tracker;

public class ExitAction extends BaseAction {
    private boolean call = false;

    public ExitAction(int key) {
        super(key, "Exit");
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
