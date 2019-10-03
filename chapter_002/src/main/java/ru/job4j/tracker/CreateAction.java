package ru.job4j.tracker;

public class CreateAction extends BaseAction {
    private boolean call = false;

    protected CreateAction(int key) {
        super(key, "Create item");
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
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