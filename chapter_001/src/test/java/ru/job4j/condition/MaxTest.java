package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {
    @Test
    public void whenMax1To2Then2() {
        Max max = new Max();
        int result = max.max(1, 2);
        assertThat(result, is(2));
    }

    @Test
    public void whenMax2To1Then1() {
        Max max = new Max();
        int result = max.max(6, 4);
        assertThat(result, is(6));
    }

    @Test
    public void whenEquals() {
        Max max = new Max();
        int result = max.max(8, 8);
        assertThat(result, is(8));
    }
}