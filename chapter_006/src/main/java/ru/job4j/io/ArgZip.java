package ru.job4j.io;

public class ArgZip {

    private final String[] args;

    private static final int DIRECTORY_INDEX = 1;
    private static final int EXCLUDE_INDEX = 3;
    private static final int OUTPUT_INDEX = 5;
    private static final int EXPECTED_ARGS = 6;

    public ArgZip(String[] args) {
        this.args = args;
    }

    public boolean valid() {
        if (args.length != EXPECTED_ARGS) {
            throw new IllegalStateException("Incorrect call. Use java -jar Zip.jar -d ARCHIVING_DIRECTORY -e EXCLUDED_FILES -o OUTPUT_ARCHIVE");
        }
        return true;
    }

    public String directory() {
        return args[DIRECTORY_INDEX];
    }

    public String exclude() {
        return args[3].substring(args[EXCLUDE_INDEX].indexOf('.'));
    }

    public String output() {
        return args[OUTPUT_INDEX];
    }
}