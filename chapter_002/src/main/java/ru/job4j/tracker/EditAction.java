package ru.job4j.tracker;

public class EditAction implements UserActions {
    private boolean call = false;

    @Override
    public String name() {
        return "Edit Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        call = true;
        String id = input.askStr("Enter number of item which you want to edit: ");
        Item item = new Item(input.askStr("Enter new name: "));
        item.setId(id);
        if (tracker.replace(id, item)) {
            System.out.println("Item has been changed");
        } else {
            System.out.println("Something went wrong");
        }
        return true;
    }
    public boolean isCall() {
        return call;
    }
}
