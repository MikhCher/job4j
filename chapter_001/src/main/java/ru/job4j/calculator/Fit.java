package ru.job4j.calculator;

public class Fit {
    public static double manWeight(double height) {
        return (height - 100) * 1.15;
    }


    public static double womanWeight(double height) {
        return (height - 110) * 1.15;
    }

    public static void main(String[] args) {
        double man = manWeight(186);
        double woman = womanWeight(156);
        System.out.println("Man 186 is " + man);
        System.out.println("Man 156 is " + woman);
    }
}
