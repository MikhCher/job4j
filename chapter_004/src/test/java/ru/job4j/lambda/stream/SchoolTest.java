package ru.job4j.lambda.stream;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SchoolTest {
    @Test
    public void whenListOfAClass() {
        School school = new School();
        List<Student> all = List.of(
                new Student(88),
                new Student(96),
                new Student(13),
                new Student(42),
                new Student(54),
                new Student(79),
                new Student(83),
                new Student(76),
                new Student(31),
                new Student(29)
        );
        List<Student> result = school.collect(all, student -> student.getScore() >= 70);
        assertTrue(result.size() == 5);
    }

    @Test
    public void whenListOfBClass() {
        School school = new School();
        List<Student> all = List.of(
                new Student(88),
                new Student(96),
                new Student(13),
                new Student(42),
                new Student(54),
                new Student(79),
                new Student(83),
                new Student(76),
                new Student(31),
                new Student(29)
        );
        List<Student> result = school.collect(all, student -> student.getScore() >= 50 && student.getScore() < 70);
        assertTrue(result.size() == 1);
    }

    @Test
    public void whenListOfCClass() {
        School school = new School();
        List<Student> all = List.of(
                new Student(88),
                new Student(96),
                new Student(13),
                new Student(42),
                new Student(54),
                new Student(79),
                new Student(83),
                new Student(76),
                new Student(31),
                new Student(29)
        );
        List<Student> result = school.collect(all, student -> student.getScore() < 50);
        assertTrue(result.size() == 4);
    }
}