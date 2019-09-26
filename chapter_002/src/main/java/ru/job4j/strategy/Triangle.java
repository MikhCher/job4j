package ru.job4j.strategy;

public class Triangle implements Shape {
    @Override
    public String draw() {
        StringBuilder sb = new StringBuilder();
        sb.append("  +  ");
        sb.append("\n + + ");
        sb.append("\n+   +");
        sb.append("\n+++++");
        return sb.toString();
    }
}
