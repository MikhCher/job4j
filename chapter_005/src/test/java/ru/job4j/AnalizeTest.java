package ru.job4j;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class AnalizeTest {
    @Test
    public void whenOneAddedOneDeletedOneChanged() {
        Analize.User firstUser = new Analize.User(1, "1");
        Analize.User secondUser = new Analize.User(2, "2");
        Analize.User thirdUser = new Analize.User(3, "3");
        Analize.User fourthUser = new Analize.User(4, "4");
        List<Analize.User> listBefore = Arrays.asList(firstUser, secondUser, thirdUser, fourthUser);
        Analize.User addedUser = new Analize.User(5, "5");
        Analize.User changedUser = new Analize.User(3, "6");
        List<Analize.User> listAfter = Arrays.asList(addedUser, secondUser, changedUser);

        Analize analize = new Analize();
        Analize.Info info = analize.diff(listBefore, listAfter);

        assertThat(info.added, is(1));
        assertThat(info.deleted, is(2));
        assertThat(info.changed, is(1));
    }
}