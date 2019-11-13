package ru.job4j.lambda.transform;

import ru.job4j.lambda.stream.Student;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListToMap {
    public Map<String, Student> trasform(List<Student> students) {
        return students.stream()
                .distinct()
                .collect(Collectors.toMap(
                        Student::getSurname,
                        student -> student
                ));
    }
}
