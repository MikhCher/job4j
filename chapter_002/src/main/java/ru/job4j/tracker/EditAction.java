package ru.job4j.tracker;

public class EditAction extends BaseAction {
    private boolean call = false;

    public EditAction(int key) {
        super(key, "Edit item");
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        call = true;
        if (tracker.findAll().length == 0) {
            System.out.println("There are no any items. You should create at least one item.");
            return true;
        }
        boolean invalid = true;
        Item item = new Item(input.askStr("Enter new name: "));
        String id = input.askStr("Enter number of item which you want to edit: ");
        do {
            try {
                item.setId(id);
                tracker.replace(id, item);
                invalid = false;
            } catch (IllegalStateException ise) {
                id = input.askStr("There is no such ID, enter correct number: ");
            }
        } while (invalid);
            System.out.println("Item has been changed");
        return true;
    }

    public boolean isCall() {
        return call;
    }
}
