package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    private static List<Path> excludedFiles;
    private static ArgZip argZip;
    private String prevDir = "";

    public void packFiles(List<Path> sources, ZipOutputStream zip) throws IOException {
        excludedFiles = Search.search(Path.of(argZip.directory()), argZip.exclude());
        for (Path file : sources) {
            packSingleFile(file.toFile(), zip);
        }
    }

    public void packSingleFile(File source, ZipOutputStream zip) throws IOException {
        String currentDir = source.toString().substring(0, source.toString().indexOf(source.getName()));
        if (excludedFiles.contains(Path.of(source.getPath()))) {
            if (!prevDir.equals(currentDir)) {
                prevDir = currentDir;
                zip.putNextEntry(new ZipEntry(source.toString().substring(0, source.toString().indexOf(source.getName()))));
            }
            return;
        }
        zip.putNextEntry(new ZipEntry(source.getPath()));
        try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
            zip.write(out.readAllBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        argZip = new ArgZip(args);
        argZip.valid();
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(argZip.output())))) {
            new Zip().packFiles(Search.search(Path.of(argZip.directory()), ""), zip);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}