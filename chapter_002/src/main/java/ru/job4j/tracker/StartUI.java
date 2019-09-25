package ru.job4j.tracker;

public class StartUI {
    public static void add(Input input, Tracker tracker) {
        System.out.println("==== Create a new item ====");
        Item item = new Item(input.askStr("Enter name of item: "));
        tracker.add(item);
    }
    public static void show(Tracker tracker) {
        System.out.println("==== Show all items item ====");
        Item[] array = tracker.findAll();
        for (int i = 0; i < array.length; i++) {
            System.out.println("#" + array[i].getId() + ", " + array[i].getName());
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
        Item[] array = tracker.findByName(input.askStr("Enter name: "));
        if (array[0] != null) {
            for (int i = 0; i < array.length; i++) {
                System.out.println("#" + array[i].getId() + ", " + array[i].getName());
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
            int select = input.askInt("Select: ");
            UserActions action = actions[select];
            run = action.execute(input, tracker);
        }
    }
    private void showMenu(UserActions[] actions) {
        System.out.println("     Menu.");
        for (int index = 0; index < actions.length; index++) {
            System.out.println(index + ". " + actions[index].name());
        }
    }
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserActions[] actions = {new CreateAction(), new ShowAction(), new EditAction(), new DeleteAction(), new FindByIDAction(), new FindByNameAction(), new ExitAction()};
        new StartUI().init(input, tracker, actions);
    }
}