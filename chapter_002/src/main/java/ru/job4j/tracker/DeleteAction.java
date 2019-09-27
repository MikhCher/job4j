package ru.job4j.tracker;

public class DeleteAction implements UserActions {
    private boolean call = false;

    @Override
    public String name() {
        return "Delete Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        call = true;
        if (tracker.delete(input.askStr("Enter number of item which you want to delete: "))) {
            System.out.println("Item has been deleted");
        } else {
            System.out.println("Something went wrong");
        }
        return true;
    }
    public boolean isCall() {
        return call;
    }
}
