package ru.job4j.calculator;

/**
 * Class Класс для вычисления арифметических операций + - / *
 * @author Mikhail Cherednichenko (28explay@gmail.com)
 * @since  21.08.2019
 * @version 1
 */
public class Calculator {
    /**
     * Сложение
     * @param first первый аргумент
     * @param second второй аргумент
     */
    public static void add(double first, double second) {
        double result =  first + second;
        System.out.println(first + "+" + second + " = " + result);
    }
    /**
     * Деление
     * @param first первый аргумент
     * @param second второй аргумент
     */
    public static void div(double first, double second) {
        double result =  first / second;
        System.out.println(first + "/" + second + " = " + result);
    }
    /**
     * Умножение
     * @param first первый аргумент
     * @param second второй аргумент
     */
    public static void multiply(double first, double second) {
        double result =  first * second;
        System.out.println(first + "*" + second + " = " + result);
    }
    /**
     * Вычитание
     * @param first первый аргумент
     * @param second второй аргумент
     */
    public static void subtrack(double first, double second) {
        double result =  first - second;
        System.out.println(first + "-" + second + " = " + result);
    }

    /**
     * Main
     * @param args аргументы
     */
    public static void main(String[] args) {
        add(1, 1);  
        div(4, 2);
        multiply(2, 1);
        subtrack(10, 5);
    }
}
