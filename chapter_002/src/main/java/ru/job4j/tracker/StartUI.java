package ru.job4j.tracker;

import java.util.List;
import java.util.function.Consumer;

public class StartUI {
    private final Consumer<String> output;

    public StartUI(Consumer<String> output) {
        this.output = output;
    }

    public static void add(Input input, Tracker tracker) {
        System.out.println("==== Create a new item ====");
        Item item = new Item(input.askStr("Enter name of item: "));
        tracker.add(item);
    }
    public static void show(Tracker tracker) {
        System.out.println("==== Show all items item ====");
        List<Item> array = tracker.findAll();
        for (Item item : array) {
            System.out.println("#" + item.getId() + ", " + item.getName());
        }
    }
    public static void edit(Input input, Tracker tracker) {
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
    public static void delete(Input input, Tracker tracker) {
        System.out.println("==== Delete item ====");
        if (tracker.delete(input.askStr("Enter number of item which you want to delete: "))) {
            System.out.println("Item has been deleted");
        } else {
            System.out.println("Something went wrong");
        }
    }
    public static void findById(Input input, Tracker tracker) {
        System.out.println("==== Find item by ID ====");
        String id = input.askStr("Enter ID: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println("#" + item.getId() + ", " + item.getName());
        } else {
            System.out.println("There is no item with this id");
        }
    }
    public static void findByName(Input input, Tracker tracker) {
        System.out.println("==== Find items by name ====");
        List<Item> array = tracker.findByName(input.askStr("Enter name: "));
        if (!array.isEmpty()) {
            for (Item item : array) {
                System.out.println("#" + item.getId() + ", " + item.getName());
            }
        } else {
            System.out.println("There is no items with this name");
        }
    }
    public static boolean exit() {
        return false;
    }
    public void init(Input input, Tracker tracker, UserActions[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ", actions.length);
            UserActions action = actions[select];
            run = action.execute(input, tracker, System.out::println);
        }
    }

    private void showMenu(UserActions[] actions) {
        output.accept("       Menu");
        for (int index = 0; index < actions.length; index++) {
            System.out.println(actions[index].info());
        }
    }
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Input validate = new ValidateInput(input);
        Tracker tracker = new Tracker();
        UserActions[] actions = {new CreateAction(0),
                                 new ShowAction(1),
                                 new EditAction(2),
                                 new DeleteAction(3),
                                 new FindByIDAction(4),
                                 new FindByNameAction(5),
                                 new ExitAction(6)};
        new StartUI(System.out::println).init(validate, tracker, actions);
    }
}