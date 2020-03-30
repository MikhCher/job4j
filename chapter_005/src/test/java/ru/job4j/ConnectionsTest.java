package ru.job4j;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ConnectionsTest {
    @Test
    public void whenFourRowsAndFreeOfThemHasSameElements() {
        List<Integer> row1 = Arrays.asList(111, 123, 222);
        List<Integer> row2 = Arrays.asList(1, 2, 3);
        List<Integer> row3 = Arrays.asList(100, 8, 7);
        List<Integer> row4 = Arrays.asList(200, 123, 100);
        List<List<Integer>> rows = new ArrayList<>();
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);
        rows.add(row4);
        Connections connections = new Connections(rows);
        var result = connections.sort();

        var expected = Arrays.asList(row1, row3, row4);
        assertThat(expected, is(result));
    }

}