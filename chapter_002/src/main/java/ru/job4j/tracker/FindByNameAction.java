package ru.job4j.tracker;

public class FindByNameAction implements UserActions {
    @Override
    public String name() {
        return "Find Items by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] array = tracker.findByName(input.askStr("Enter name: "));
        if (array[0] != null) {
            for (int i = 0; i < array.length; i++) {
                System.out.println("#" + array[i].getId() + ", " + array[i].getName());
            }
        } else {
            System.out.println("There is no items with this name");
        }
        return true;
    }
}
