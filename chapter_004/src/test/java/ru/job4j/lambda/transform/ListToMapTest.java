package ru.job4j.lambda.transform;

import org.junit.Test;
import ru.job4j.lambda.stream.Student;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ListToMapTest {
    @Test
    public void transformStudentsListToStudentsMap() {
        ListToMap transformator = new ListToMap();
        Student first = new Student("Dmitriy", "Lukanichev", 65);
        Student second = new Student("Ivan", "Smirnov", 87);
        Student third = new Student("Daniil", "Kroshko", 43);
        Map<String, Student> result = transformator.trasform(Arrays.asList(first, second, third));
        Set<String> expect = new HashSet<>(Arrays.asList(first.getSurname(), second.getSurname(), third.getSurname()));
        assertThat(result.keySet(), is(expect));
    }
}