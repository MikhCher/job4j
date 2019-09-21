package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {
    private void add(Scanner scanner, Tracker tracker) {
        System.out.println("==== Create a new item ====");
        System.out.print("Enter name of item: ");
        Item item = new Item(scanner.nextLine());
        tracker.add(item);
    }
    private void show(Scanner scanner, Tracker tracker) {
        System.out.println("==== Show all items item ====");
        Item[] array = tracker.findAll();
        for (int i = 0; i < array.length; i++) {
            System.out.println("#" + array[i].getId() + ", " + array[i].getName());
        }
    }
    private void edit(Scanner scanner, Tracker tracker) {
        System.out.println("==== Edit item ====");
        System.out.print("Enter number of item which you want to edit: ");
        String id = scanner.nextLine();
        System.out.print("Enter new name: ");
        Item item = new Item(scanner.nextLine());
        item.setId(id);
        if (tracker.replace(id, item)) {
            System.out.println("Item has been changed");
        } else {
            System.out.println("Something went wrong");
        }
    }
    private void delete(Scanner scanner, Tracker tracker) {
        System.out.println("==== Delete item ====");
        System.out.print("Enter number of item which you want to delete: ");
        if (tracker.delete(scanner.nextLine())) {
            System.out.println("Item has been deleted");
        } else {
            System.out.println("Something went wrong");
        }
    }
    private void findById(Scanner scanner, Tracker tracker) {
        System.out.println("==== Find item by ID ====");
        System.out.print("Enter ID: ");
        String id = scanner.nextLine();
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println("#" + item.getId() + ", " + item.getName());
        } else {
            System.out.println("There is no item with this id");
        }
    }
    private void findByName(Scanner scanner, Tracker tracker) {
        System.out.println("==== Find items by name ====");
        System.out.print("Enter name: ");
        Item[] array = tracker.findByName(scanner.nextLine());
        if (array[0] != null) {
            for (int i = 0; i < array.length; i++) {
                System.out.println("#" + array[i].getId() + ", " + array[i].getName());
            }
        } else {
            System.out.println("There is no items with this name");
        }
    }
    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                add(scanner, tracker);
            } else if (select == 1) {
                show(scanner, tracker);
            } else if (select == 2) {
                edit(scanner, tracker);
            } else if (select == 3) {
                delete(scanner, tracker);
            } else if (select == 4) {
                findById(scanner, tracker);
            } else if (select == 5) {
                findByName(scanner, tracker);
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
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}