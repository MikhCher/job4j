package ru.job4j.departament;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class SortDepartmentTest {
    @Test
    public void whenAscendingSorting() {
        SortDepartment sort = new SortDepartment();
        Division first = new Division("K1");
        Division second = new Division("K1/SK1");
        Division third = new Division("K1/SK1/SSK1");
        Division fourth = new Division("K1/SK1/SSK2");
        Division fifth = new Division("K1/SK2");
        Division sixth = new Division("K2");
        Division seventh = new Division("K2/SK1");
        Division eighth = new Division("K2/SK1/SSK1");
        Division ninth = new Division("K2/SK1/SSK2");
        Set<Division> set = new HashSet<>(Arrays.asList(
                second, fifth, seventh, third, fourth, sixth, first, eighth, ninth
        ));
        Division[] result = new Division[9];
        sort.ascendingSort(set).toArray(result);
        Division[] expect = {first, second, third, fourth, fifth, sixth, seventh, eighth, ninth};
        assertThat(result, is(expect));
    }

    @Test
    public void whenDescendingSorting() {
        SortDepartment sort = new SortDepartment();
        Division first = new Division("K2");
        Division second = new Division("K2/SK1");
        Division third = new Division("K2/SK1/SSK2");
        Division fourth = new Division("K2/SK1/SSK1");
        Division fifth = new Division("K1");
        Division sixth = new Division("K1/SK2");
        Division seventh = new Division("K1/SK1");
        Division eighth = new Division("K1/SK1/SSK2");
        Division ninth = new Division("K1/SK1/SSK1");
        Set<Division> set = new HashSet<>(Arrays.asList(
                second, fifth, seventh, third, fourth, sixth, first, eighth, ninth
        ));
        Division[] result = new Division[9];
        sort.descendingSort(set).toArray(result);
        Division[] expect = {first, second, third, fourth, fifth, sixth, seventh, eighth, ninth};
        assertThat(result, is(expect));
    }
}