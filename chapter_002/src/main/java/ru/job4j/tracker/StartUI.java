package ru.job4j.tracker;

public class StartUI {
    private void add(Input input, Tracker tracker) {
        System.out.println("==== Create a new item ====");
        Item item = new Item(input.askStr("Enter name of item: "));
        tracker.add(item);
    }
    private void show(Input input, Tracker tracker) {
        System.out.println("==== Show all items item ====");
        Item[] array = tracker.findAll();
        for (int i = 0; i < array.length; i++) {
            System.out.println("#" + array[i].getId() + ", " + array[i].getName());
        }
    }
    private void edit(Input input, Tracker tracker) {
        System.out.println("==== Edit item ====");
        String id = input.askStr("Enter number of item which you want to edit: ");
        Item item = new Item(input.askStr("Enter new name: "));
        item.setId(id);
        if (tracker.replace(id, item)) {
            System.out.println("Item has been changed");
        } else {
            System.out.println("Something went wrong");
        }
    }
    private void delete(Input input, Tracker tracker) {
        System.out.println("==== Delete item ====");
        if (tracker.delete(input.askStr("Enter number of item which you want to delete: "))) {
            System.out.println("Item has been deleted");
        } else {
            System.out.println("Something went wrong");
        }
    }
    private void findById(Input input, Tracker tracker) {
        System.out.println("==== Find item by ID ====");
        String id = input.askStr("Enter ID: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println("#" + item.getId() + ", " + item.getName());
        } else {
            System.out.println("There is no item with this id");
        }
    }
    private void findByName(Input input, Tracker tracker) {
        System.out.println("==== Find items by name ====");
        Item[] array = tracker.findByName(input.askStr("Enter name: "));
        if (array[0] != null) {
            for (int i = 0; i < array.length; i++) {
                System.out.println("#" + array[i].getId() + ", " + array[i].getName());
            }
        } else {
            System.out.println("There is no items with this name");
        }
    }
    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(input.askStr("Select: "));
            if (select == 0) {
                add(input, tracker);
            } else if (select == 1) {
                show(input, tracker);
            } else if (select == 2) {
                edit(input, tracker);
            } else if (select == 3) {
                delete(input, tracker);
            } else if (select == 4) {
                findById(input, tracker);
            } else if (select == 5) {
                findByName(input, tracker);
            } else {
                run = false;
            }

        }
    }



    private void showMenu() {
        System.out.println("===============================\nMenu.");
        System.out.println("0. Add new item");
        System.out.println("1. Show all Items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by ID");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit program");
    }


    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}