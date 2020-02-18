package ru.job4j.set;

import org.junit.Test;
import ru.job4j.map.DefaultMap;
import ru.job4j.map.User;

import static org.junit.Assert.assertTrue;

public class DefaultMapTest {

    @Test
    public void whenMapContainsTwoUsersWithSameFields() {
        DefaultMap def = new DefaultMap();
        User first = new User("Mikhail", 0, null);
        User second = new User("Mikhail", 0, null);

        def.add(first, 1);
        def.add(second, 2);
        def.printMap();

        assertTrue(first.hashCode() == second.hashCode());
        assertTrue(first.equals(second));
    }
}