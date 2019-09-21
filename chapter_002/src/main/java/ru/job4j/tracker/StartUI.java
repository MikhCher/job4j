package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            switch (select) {
                case 0: {
                    System.out.println("==== Create a new item ====");
                    System.out.print("Enter name of item: ");
                    Item item = new Item(scanner.nextLine());
                    tracker.add(item);
                    break;
                }
                case 1: {
                    System.out.println("==== Show all items item ====");
                    Item[] array = tracker.findAll();
                    for (int i = 0; i < array.length; i++) {
                        System.out.println("#" + array[i].getId() + ", " + array[i].getName());
                    }
                    break;
                }
                case 2: {
                    System.out.println("==== Edit item ====");
                    System.out.print("Enter number of item which you want to edit: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter new name: ");
                    Item item = new Item(scanner.nextLine());
                    item.setId(id);
                    tracker.replace(id, item);
                    break;
                }
                case 3: {
                    System.out.println("==== Delete item ====");
                    System.out.print("Enter number of item which you want to delete: ");
                    tracker.delete(scanner.nextLine());
                    break;
                }
                case 4: {
                    System.out.println("==== Find item by ID ====");
                    System.out.print("Enter ID: ");
                    System.out.println("#" + tracker.findById(scanner.nextLine()).getId() + ", " + tracker.findById(scanner.nextLine()).getName());
                    break;
                }
                case 5: {
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
                    break;
                }
                case 6: {
                    run = false;
                    break;
                }
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