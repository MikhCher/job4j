package ru.job4j.tracker;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.List;
import java.util.StringJoiner;
import java.util.Random;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final PrintStream def = System.out;

    @Test
    public void whenAddItem() {
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.add(input, tracker);
        Item created = tracker.findAll().get(0);
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
        List<Item> result = tracker.findAll();
        assertTrue(result.isEmpty());
    }
    @Test
    public void whenExit() {
        StubInput input = new StubInput(
                new String[] {"0"}
        );
        StubAction action = new StubAction(0);
        new StartUI(System.out::println).init(input, new Tracker(), new UserActions[] {action });
        assertThat(action.isCall(), is(true));
    }
    @Test
    public void whenAdd() {
        StubInput input = new StubInput(
                new String[] {"0", "Add test", "1"}
        );
        CreateAction action = new CreateAction(0);
        new StartUI(System.out::println).init(input, new Tracker(), new UserActions[] {action, new ExitAction(1) });
        assertThat(action.isCall(), is(true));
    }
    @Test
    public void whenShow() {
        StubInput input = new StubInput(
                new String[] {"0", "1"}
        );
        ShowAction action = new ShowAction(0);
        new StartUI(System.out::println).init(input, new Tracker(), new UserActions[] {action, new ExitAction(1) });
        assertThat(action.isCall(), is(true));
    }
    @Test
    public void whenEdit() {
        StubInput input = new StubInput(
                new String[] {"0", "1"}
        );
        EditAction action = new EditAction(0);
        new StartUI(System.out::println).init(input, new Tracker(), new UserActions[] {action, new ExitAction(1) });
        assertThat(action.isCall(), is(true));
    }
    @Test
    public void whenDelete() {
        StubInput input = new StubInput(
                new String[] {"0", "1"}
        );
        DeleteAction action = new DeleteAction(0);
        new StartUI(System.out::println).init(input, new Tracker(), new UserActions[] {action, new ExitAction(1) });
        assertThat(action.isCall(), is(true));
    }
    @Test
    public void whenFindByID() {
        StubInput input = new StubInput(
                new String[] {"0", "1"}
        );
        FindByIDAction action = new FindByIDAction(0);
        new StartUI(System.out::println).init(input, new Tracker(), new UserActions[] {action, new ExitAction(1) });
        assertThat(action.isCall(), is(true));
    }
    @Test
    public void whenFindByName() {
        StubInput input = new StubInput(
                new String[] {"0", "1"}
        );
        FindByNameAction action = new FindByNameAction(0);
        new StartUI(System.out::println).init(input, new Tracker(), new UserActions[] {action, new ExitAction(1) });
        assertThat(action.isCall(), is(true));
    }
    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }
    @After
    public void backOutput() {
        System.setOut(this.def);
    }
    @Test
    public void whenPrtMenu() {
        StubInput input = new StubInput(
                new String[] {"0"}
        );
        StubAction action = new StubAction(0);
        new StartUI(System.out::println).init(input, new Tracker(), new UserActions[] {action });
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("       Menu")
                .add("0 : Stub action")
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
    }
    @Test
    public void whenCheckOutputOnShowAction() {
        Tracker tracker = new Tracker();
        Item item = new Item("fix bug");
        tracker.add(item);
        ShowAction act = new ShowAction(0);
        act.execute(new StubInput(new String[] {}), tracker, System.out::println);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("#" + item.getId() + ", " + item.getName())
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
    }
    @Test
    public void whenCheckOutputOnFindByNameAction() {
        Tracker tracker = new Tracker();
        Item item = new Item("fix bug");
        tracker.add(item);
        FindByNameAction act = new FindByNameAction(0);
        act.execute(new StubInput(new String[] {"fix bug"}), tracker, System.out::println);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("#" + item.getId() + ", " + item.getName())
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
    }
}