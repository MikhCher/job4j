package ru.job4j.lambda.mail;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class UserDataBaseTest {
    @Test
    public void whenFiveUsersButThreeOfThemHasSimilarMails() {
        UserDataBase post = new UserDataBase();
        User user1 = new User("user1");
        User user2 = new User("user2");
        User user3 = new User("user3");
        User user4 = new User("user4");
        User user5 = new User("user5");
        post.setUsers(List.of(user1, user2, user3, user4, user5));
        post.addMailToUser(user1, List.of("xxx@ya.ru", "foo@gmail.com", "lol@mail.ru"));
        post.addMailToUser(user2, List.of("foo@gmail.com", "ups@pisem.net"));
        post.addMailToUser(user3, List.of("xyz@pisem.net", "vasya@pupkin.com"));
        post.addMailToUser(user4, List.of("ups@pisem.net", "aaa@bbb.ru"));
        post.addMailToUser(user5, List.of("xyz@pisem.net"));
        post.squashUsers();
        Map<User, List<String>> result = post.getMap();
        Map<User, List<String>> expect = Map.of(
                user3, List.of("xyz@pisem.net", "vasya@pupkin.com"),
                user1, List.of("xxx@ya.ru", "foo@gmail.com", "lol@mail.ru", "ups@pisem.net", "aaa@bbb.ru"));
        assertThat(result, is(expect));
    }
}