package ru.job4j.io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.nio.file.Files;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AnalysisTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void whenServerDoesNotWorkTwoTimes() throws IOException {
        Analysis analysis = new Analysis();
        File source = folder.newFile("unavailable.csv");
        File target = folder.newFile("target.txt");
        Files.write(source.toPath(), List.of(
                "200 10:56:01",
                "200 10:57:01",
                "400 10:58:01",
                "200 10:59:01",
                "500 11:01:02",
                "400 11:02:02",
                "200 11:03:02"
        ));
        analysis.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        List<String> result = Files.readAllLines(target.toPath());
        assertThat(result.get(0), is("10:58:01;10:59:01"));
        assertThat(result.get(1), is("11:01:02;11:03:02"));
    }
}