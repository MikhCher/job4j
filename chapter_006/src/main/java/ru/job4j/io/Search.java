package ru.job4j.io;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.FileVisitResult.CONTINUE;

public class Search implements FileVisitor<Path> {
    private static List<Path> foundFiles = new ArrayList<>();
    private static String expansion;

    public static void main(String[] args) throws IOException {
        Path start = Paths.get(".");
        search(start, ".js");
    }

    public static void setExpansion(String expansion) {
        Search.expansion = expansion;
    }

    public static void search(Path root, String ext) throws IOException {
        setExpansion(ext);
        Files.walkFileTree(root, new Search());
        foundFiles.forEach(path -> System.out.println(path.toString()));
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (file.getFileName().toString().endsWith(expansion)) {
            foundFiles.add(file);
        }
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return CONTINUE;
    }
}