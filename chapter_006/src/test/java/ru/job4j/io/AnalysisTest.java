package ru.job4j.io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class AnalysisTest {

    @Test
    public void whenServerDoesNotWorkTwoTimes() {
        Analysis analysis = new Analysis();
        analysis.unavailable("D:\\projects\\Job4j\\unavailable.csv", "D:\\projects\\Job4j\\target.txt");
        try (BufferedReader read = new BufferedReader(new FileReader("D:\\projects\\Job4j\\target.txt"))) {
            assertThat(read.readLine(), is("10:58:01;10:59:01"));
            assertThat(read.readLine(), is("11:01:02;11:03:02"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}