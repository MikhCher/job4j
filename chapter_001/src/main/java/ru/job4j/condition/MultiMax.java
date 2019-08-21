package ru.job4j.condition;

public class MultiMax {
    public int max(int first, int second, int third) {
        int result = third;
        result = first > second && first > third ? first : third;
        if (result != first) {
            result = second > first && second > third ? second : third;
        }
        return result;
    }
}