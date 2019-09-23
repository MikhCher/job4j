package ru.job4j.tracker;

public class StartUI {
    private static void add(Input input, Tracker tracker) {
        System.out.println("==== Create a new item ====");
        System.out.print("Enter name of item: ");
        Item item = new Item(input.askStr(""));
        tracker.add(item);
    }
    private static void show(Input input, Tracker tracker) {
        System.out.println("==== Show all items item ====");
        Item[] array = tracker.findAll();
        for (int i = 0; i < array.length; i++) {
            System.out.println("#" + array[i].getId() + ", " + array[i].getName());
        }
    }
    private static void edit(Input input, Tracker tracker) {
        System.out.println("==== Edit item ====");
        System.out.print("Enter number of item which you want to edit: ");
        String id = input.askStr("");
        System.out.print("Enter new name: ");
        Item item = new Item(input.askStr(""));
        item.setId(id);
        if (tracker.replace(id, item)) {
            System.out.println("Item has been changed");
        } else {
            System.out.println("Something went wrong");
        }
    }
    private static void delete(Input input, Tracker tracker) {
        System.out.println("==== Delete item ====");
        System.out.print("Enter number of item which you want to delete: ");
        if (tracker.delete(input.askStr(""))) {
            System.out.println("Item has been deleted");
        } else {
            System.out.println("Something went wrong");
        }
    }
    private static void findById(Input input, Tracker tracker) {
        System.out.println("==== Find item by ID ====");
        System.out.print("Enter ID: ");
        String id = input.askStr("");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println("#" + item.getId() + ", " + item.getName());
        } else {
            System.out.println("There is no item with this id");
        }
    }
    private static void findByName(Input input, Tracker tracker) {
        System.out.println("==== Find items by name ====");
        System.out.print("Enter name: ");
        Item[] array = tracker.findByName(input.askStr(""));
        if (array[0] != null) {
            for (int i = 0; i < array.length; i++) {
                System.out.println("#" + array[i].getId() + ", " + array[i].getName());
            }
        } else {
            System.out.println("There is no items with this name");
        }
    }
    private static boolean exit() {
        return false;
    }
    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(input.askStr(""));
            if (select == 0) {
                StartUI.add(input, tracker);
            } else if (select == 1) {
                StartUI.show(input, tracker);
            } else if (select == 2) {
                StartUI.edit(input, tracker);
            } else if (select == 3) {
                StartUI.delete(input, tracker);
            } else if (select == 4) {
                StartUI.findById(input, tracker);
            } else if (select == 5) {
                StartUI.findByName(input, tracker);
            } else {
                run = StartUI.exit();
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