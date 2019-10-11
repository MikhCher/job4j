package ru.job4j.machine;

import org.junit.Test;
import static org.hamcrest.Matchers.is;

import static org.junit.Assert.*;

public class CoffeeTest {

    @Test
    public void changes() {
        Coffee coffee = new Coffee();
        int[] result = coffee.changes(50, 35);
        int[] expect = {10 , 5};
        assertThat(result, is(expect));
    }
}