package ru.job4j.tracker;

public class DeleteAction extends BaseAction {
    private boolean call = false;

    public DeleteAction(int key) {
        super(key, "Delete item");
    }
    @Override
    public boolean execute(Input input, Tracker tracker) {
        call = true;
        boolean invalid = true;
        if (tracker.findAll().isEmpty()) {
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
        } while (invalid);
        System.out.println("Item has been deleted");
        return true;
    }
    public boolean isCall() {
        return call;
    }
}
