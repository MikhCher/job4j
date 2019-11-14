package ru.job4j.lambda.innovated;

import java.util.List;
import java.util.stream.Collectors;

public class Selection {
    List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .filter(student -> student.getName() != null)
                .sorted()
                .takeWhile(student -> student.getScope() > bound)
                .collect(Collectors.toList());
    }
}
