package ru.job4j.set;

import ru.job4j.map.User;

import java.util.HashMap;
import java.util.Map;

public class DefaultMap {
    Map<User, Object> map = new HashMap<>();

    public void printMap() {
        System.out.println(map);
    }

    public void add(User user, Object o) {
        map.put(user, o);
    }
}
