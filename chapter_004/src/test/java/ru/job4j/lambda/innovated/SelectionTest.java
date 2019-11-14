package ru.job4j.lambda.innovated;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class SelectionTest {
    @Test
    public void selectStudentWithAScoreGreaterThen3() {
        Selection select = new Selection();
        Student first = new Student("Ivan Smirnov", 5);
        Student nullStudent1 = new Student();
        Student second = new Student("Pavel Doronin", 3);
        Student nullStudent2 = new Student();
        Student third = new Student("Denis Grigiriev", 4);
        List<Student> result = select.levelOf(Arrays.asList(first, nullStudent1, second, nullStudent2, third), 3);
        List<Student> expect = Arrays.asList(first, third);
        assertThat(result, is(expect));
    }
}