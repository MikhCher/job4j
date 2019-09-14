package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1");
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2");
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void whenDeleteItemThenReturnTrue() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1");
        Item second = new Item("test2");
        Item third = new Item("test3");
        boolean result;
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        result = tracker.delete(second.getId());
        assertThat(result, is(true));
    }

    @Test
    public void whenFindAllThenReturnAllNotNull() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1");
        Item second = new Item("test2");
        Item third = new Item("test3");
        Item[] expect = {first, second, third};
        Item[] result;
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        result = tracker.findAll();
        assertThat(result, is(expect));
    }

    @Test
    public void WhenFindByNameThenReturnArrayOfItems() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("TEST");
        tracker.add(item1);
        Item[] expect = {item1};
        Item[] result = tracker.findByName("TEST");
        assertThat(result, is(expect));
    }
}