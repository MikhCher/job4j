package ru.job4j.condition;

public class MultiMax {
    public int max(int first, int second, int third) {
        int rsl = first > second ? first : second;
        int result = third > rsl ? third : rsl;
        return result;
    }
}