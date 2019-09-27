package ru.job4j.tracker;

public class FindByNameAction implements UserActions {
    private boolean call = false;

    @Override
    public String name() {
        return "Find Items by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        call = true;
        Item[] array = tracker.findByName(input.askStr("Enter name: "));
        if (array.length != 0) {
            for (int i = 0; i < array.length; i++) {
                System.out.println("#" + array[i].getId() + ", " + array[i].getName());
            }
        } else {
            System.out.println("There is no items with this name");
        }
        return true;
    }
    public boolean isCall() {
        return call;
    }
}
