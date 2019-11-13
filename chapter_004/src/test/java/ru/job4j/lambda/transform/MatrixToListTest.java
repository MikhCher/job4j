package ru.job4j.lambda.transform;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MatrixToListTest {
    @Test
    public void transformIntegerMatrixToList() {
        MatrixToList transformer = new MatrixToList();
        Integer[][] matrix = {{1, 7, 2}, {5, 2, 4}, {7, 6, 9}};
        List<Integer> result = transformer.transform(matrix);
        List<Integer> expect = Arrays.asList(1, 7, 2, 5, 2, 4, 7, 6, 9);
        assertThat(result, is(expect));
    }
}