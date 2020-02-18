package ru.job4j.set;

import org.junit.Test;
import ru.job4j.map.DefaultMap;
import ru.job4j.map.User;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.*;


public class DefaultMapTest {

    @Test
    public void whenMapContainsTwoUsersWithSameFields() {
        DefaultMap def = new DefaultMap();
        User first = new User("Mikhail", 0, null);
        User second = new User("Mikhail", 0, null);

        def.add(first, 1);
        def.add(second, 2);
        def.printMap();

        assertThat(first.equals(second), is(true) );
    }

}