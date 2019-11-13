package ru.job4j.lambda.transform;

import java.util.Arrays;
import java.util.List;
import java.util.stream.*;

public class MatrixToList {
    public List<Integer> transform(Integer[][] matrix) {
        return Stream.of(matrix)
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
    }
}
