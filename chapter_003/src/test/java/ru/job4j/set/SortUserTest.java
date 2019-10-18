package ru.job4j.set;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.*;

public class SortUserTest {
    @Test
    public void whenSortingUsers() {
        SortUser user = new SortUser();
        User first = new User(27, "Arkadiy");
        User second = new User(32, "Sergey");
        User third = new User(18, "Mikhail");
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(first, second, third));
        Set<User> result = user.sort(list);
        Set<User> expect = new TreeSet<>();
        expect.addAll(Arrays.asList(third, first, second));
        assertThat(result, is(expect));
    }
}