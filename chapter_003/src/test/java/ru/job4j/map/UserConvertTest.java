package ru.job4j.map;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

public class UserConvertTest {

    @Test
    public void whenConvertListToMap() {
        UserConvert userConvert = new UserConvert();
        List<User> list = new ArrayList<>();
        User user = new User(4015, "Михаил", "Санкт-Петербург");
        list.add(user);
        HashMap<Integer, User> result = userConvert.process(list);
        assertTrue(result.containsKey(4015));
    }
}