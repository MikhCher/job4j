package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SqMaxTest {
    @Test
    public void whenFirstMax() {
        SqMax check = new SqMax();
        int result = check.max(5, 4, 3, 1);
        assertThat(result, is(5));
    }

    @Test
    public void whenSecondMax() {
        SqMax check = new SqMax();
        int result = check.max(4, 7, 5, 6);
        assertThat(result, is(7));
    }

    @Test
    public void whenThirdMax() {
        SqMax check = new SqMax();
        int result = check.max(1, 4, 7, 2);
        assertThat(result, is(7));
    }

    @Test
    public void whenFourthMax() {
        SqMax check = new SqMax();
        int result = check.max(1, 2, 3, 4);
        assertThat(result, is(4));
    }
}