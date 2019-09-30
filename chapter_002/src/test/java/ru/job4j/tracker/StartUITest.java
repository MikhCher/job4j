package ru.job4j.tracker;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.StringJoiner;
import java.util.Random;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {

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
    @Test
    public void whenAdd() {
        StubInput input = new StubInput(
                new String[] {"0", "Add test", "1"}
        );
        CreateAction action = new CreateAction();
        new StartUI().init(input, new Tracker(), new UserActions[] { action, new ExitAction() });
        assertThat(action.isCall(), is(true));
    }
    @Test
    public void whenShow() {
        StubInput input = new StubInput(
                new String[] {"0", "1"}
        );
        ShowAction action = new ShowAction();
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
        new StartUI().init(input, new Tracker(), new UserActions[] { action, new ExitAction() });
        assertThat(action.isCall(), is(true));
    }
    @Test
    public void whenFindByName() {
        StubInput input = new StubInput(
                new String[] {"0", "Random name", "1"}
        );
        FindByNameAction action = new FindByNameAction();
        new StartUI().init(input, new Tracker(), new UserActions[] { action, new ExitAction() });
        assertThat(action.isCall(), is(true));
    }
    @Test
    public void whenPrtMenu() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));
        StubInput input = new StubInput(
                new String[] {"0"}
        );
        StubAction action = new StubAction();
        new StartUI().init(input, new Tracker(), new UserActions[] { action });
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("     Menu.")
                .add("0. Stub action")
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }
    @Test
    public void whenCheckOutputOnShowAction() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));
        Tracker tracker = new Tracker();
        Item item = new Item("fix bug");
        tracker.add(item);
        ShowAction act = new ShowAction();
        act.execute(new StubInput(new String[] {}), tracker);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("#" + item.getId() + ", " + item.getName())
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }
    @Test
    public void whenCheckOutputOnFindByNameAction() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));
        Tracker tracker = new Tracker();
        Item item = new Item("fix bug");
        tracker.add(item);
        FindByNameAction act = new FindByNameAction();
        act.execute(new StubInput(new String[] {"fix bug"}), tracker);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("#" +item.getId() + ", " + item.getName())
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }
}