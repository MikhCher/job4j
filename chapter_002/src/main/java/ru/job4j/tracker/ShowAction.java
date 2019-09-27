package ru.job4j.tracker;

public class ShowAction implements UserActions {
    private boolean call = false;

    @Override
    public String name() {
        return "Show all Items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        call = true;
        Item[] array = tracker.findAll();
        for (int i = 0; i < array.length; i++) {
            System.out.println("#" + array[i].getId() + ", " + array[i].getName());
        }
        return true;
    }
    public boolean isCall() {
        return call;
    }
}
