package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class DiapasonCounterTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        DiapasonCounter function = new DiapasonCounter();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenLinearResults() {
        DiapasonCounter function = new DiapasonCounter();
        List<Double> result = function.diapason(0, 4, x -> 4 * Math.pow(x, 2) + 4 * x + 1);
        List<Double> expected = Arrays.asList(1D, 9D, 25D, 49D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLogarithmicFThenLinearResults() {
        DiapasonCounter function = new DiapasonCounter();
        List<Double> result = function.diapason(1, 2, x -> 2 * Math.log(x));
        List<Double> expected = Arrays.asList(0D);
        assertThat(result, is(expected));
    }
}