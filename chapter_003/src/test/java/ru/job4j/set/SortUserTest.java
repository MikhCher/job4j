package ru.job4j.set;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.*;

public class SortUserTest {
    @Test
    public void whenSortingUsersByAge() {
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

    @Test
    public void whenSortingUsersByNameLength() {
        SortUser user = new SortUser();
        List<User> list = new ArrayList<>();
        User first = new User(47, "Vladimir");
        User second = new User(13, "Mike");
        User third = new User(21, "Andrey");
        list.addAll(Arrays.asList(first, second, third));
        List<User> result = user.sortNameLength(list);
        List<User> expect = new ArrayList<>();
        expect.addAll(Arrays.asList(second, third, first));
        assertThat(result, is(expect));
    }

    @Test
    public void whenSortingByAllFields() {
        SortUser user = new SortUser();
        List<User> list = new ArrayList<>();
        User first = new User(25, "Sergey");
        User second = new User(30, "Ivan");
        User third = new User(20, "Sergey");
        User fourth = new User(25, "Ivan");
        list.addAll(Arrays.asList(first, second, third, fourth));
        List<User> result = user.sortByAllFields(list);
        List<User> expect = new ArrayList<>();
        expect.addAll(Arrays.asList(fourth, second, third, first));
        assertThat(result, is(expect));
    }
}