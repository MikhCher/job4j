package ru.job4j.tracker;

public class CreateAction implements UserActions {
    private boolean call = false;

    @Override
    public String name() {
        return "Create a new Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        call = true;
        System.out.print("Enter name: ");
        String name = input.askStr("");
        Item item = new Item(name);
        tracker.add(item);
        return true;
    }
    public boolean isCall() {
        return call;
    }
}
