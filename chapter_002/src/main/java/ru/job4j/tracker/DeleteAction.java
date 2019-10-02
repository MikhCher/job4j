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
        boolean invalid = true;
        if (tracker.findAll().length == 0) {
            System.out.println("There are no any items. You should create at least one item.");
            return true;
        }
        String id = input.askStr("Enter ID of item which you want to delete: ");
        do {

            try {
                tracker.delete(id);
                invalid = false;
            } catch (IllegalStateException ise) {
                id = input.askStr("There is no such ID, enter correct number: ");
            }
        } while(invalid);
        System.out.println("Item has been deleted");
        return true;
    }
    public boolean isCall() {
        return call;
    }
}
