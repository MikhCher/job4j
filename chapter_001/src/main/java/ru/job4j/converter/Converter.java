package ru.job4j.converter;

public class Converter {
    public static int rubleToEuro(int value) {
        return value / 70;
    }

    public static int rubleToDollar(int value) {
        return value / 60;
    }

    public static int euroToRuble(int value) {
        return value * 70;
    }

    public static int dollarToRuble(int value) {
        return value * 60;
    }

    public static void main(String[] args) {
        int expected = 2;
        int out = rubleToEuro(140);
        boolean passed = expected == out;
        System.out.println("140 rubles are 2 euro. Test result : " + passed);

        expected = 4;
        out = rubleToDollar(240);
        passed = expected == out;
        System.out.println("240 rubles are 4. Test result : " + passed);

        expected = 210;
        out = euroToRuble(3);
        passed = expected == out;
        System.out.println("3 euros are 210 rubles. Test result : " + passed);

        expected = 300;
        out = dollarToRuble(5);
        passed = expected == out;
        System.out.println("5 dollars are 300 rubles. Test result : " + passed);
    }
}
