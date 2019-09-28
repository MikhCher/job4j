package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {
    private int counter = 0;
    private String[] choice = new String[10];

    @Test
    public void whenAddItem() {
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.add(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }
    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {item.getId(), "Edited"};
        StartUI.edit(new StubInput(answers), tracker);
        Item edited = tracker.findById(item.getId());
        assertThat(edited.getName(), is("Edited"));
    }
    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new");
        tracker.add(item);
        String[] answers = {item.getId()};
        Input input = new StubInput(answers);
        StartUI.delete(input, tracker);
        Item[] result = tracker.findAll();
        assertThat(result.length, is(0));
    }
    @Test
    public void whenExit() {
        StubInput input = new StubInput(
                new String[] {"0"}
        );
        StubAction action = new StubAction();
        new StartUI().init(input, new Tracker(), new UserActions[] { action });
        assertThat(action.isCall(), is(true));
    }
    @Before
    public void before() {

    }
    @Test
    public void whenAdd() {
        StubInput input = new StubInput(
                new String[] {"0", "Add test", "1"}
        );
        CreateAction action = new CreateAction();
        choice[counter++] = action.name();
        new StartUI().init(input, new Tracker(), new UserActions[] { action, new ExitAction() });
        assertThat(action.isCall(), is(true));
    }
    @Test
    public void whenShow() {
        StubInput input = new StubInput(
                new String[] {"0", "1"}
        );
        ShowAction action = new ShowAction();
        choice[counter++] = action.name();
        new StartUI().init(input, new Tracker(), new UserActions[] { action, new ExitAction() });
        assertThat(action.isCall(), is(true));
    }
    @Test
    public void whenEdit() {
        Random rm = new Random();
        StubInput input = new StubInput(
                new String[] {"0", String.valueOf(rm.nextLong() + System.currentTimeMillis()), "Edit test", "1"}
        );
        EditAction action = new EditAction();
        choice[counter++] = action.name();
        new StartUI().init(input, new Tracker(), new UserActions[] { action, new ExitAction() });
        assertThat(action.isCall(), is(true));
    }
    @Test
    public void whenDelete() {
        Random rm = new Random();
        StubInput input = new StubInput(
                new String[] {"0", String.valueOf(rm.nextLong() + System.currentTimeMillis()), "1"}
        );
        DeleteAction action = new DeleteAction();
        choice[counter++] = action.name();
        new StartUI().init(input, new Tracker(), new UserActions[] { action, new ExitAction() });
        assertThat(action.isCall(), is(true));
    }
    @Test
    public void whenFindByID() {
        Random rm = new Random();
        StubInput input = new StubInput(
                new String[] {"0", String.valueOf(rm.nextLong() + System.currentTimeMillis()), "1"}
        );
        FindByIDAction action = new FindByIDAction();
        choice[counter++] = action.name();
        new StartUI().init(input, new Tracker(), new UserActions[] { action, new ExitAction() });
        assertThat(action.isCall(), is(true));
    }
    @Test
    public void whenFindByName() {
        StubInput input = new StubInput(
                new String[] {"0", "Random name", "1"}
        );
        FindByNameAction action = new FindByNameAction();
        choice[counter++] = action.name();
        new StartUI().init(input, new Tracker(), new UserActions[] { action, new ExitAction() });
        assertThat(action.isCall(), is(true));
    }
    @After
    public void after() {
        String[] array = new String[counter];
        System.arraycopy(choice, 0, array, 0, counter);
        System.out.println("\n\nUser-selected menu items: ");
        for (String i: array) {
            System.out.println(i);
        }
        System.out.println("Exit");
    }
}