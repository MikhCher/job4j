package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RandomBot {
    private static File answers;
    private static File log;

    private static final List<String> answerList = new ArrayList<>();

    private static final String CONTINUE = "продолжить";
    private static final String STOP = "стоп";
    private static final String END = "закончить";

    public RandomBot(final String answers, final String log) {
        RandomBot.answers = new File(answers);
        RandomBot.log = new File(log);
    }

    public static void main(String[] args) {
        new RandomBot("RandomBotAnswers.txt", "RandomBotLog.txt");
        start();
    }

    private static void start() {
        boolean work = true;
        String message;

        loadAnswers();

        try (PrintWriter out = new PrintWriter(new FileOutputStream(log))) {
            while (!(message = getUserMessage()).equals(END)) {
                out.write("Вы:  ");
                out.write(message);
                out.write(System.lineSeparator());
                if (message.equals(STOP)) {
                    work = false;
                    continue;
                }
                if (message.equals(CONTINUE)) {
                    work = true;
                }
                if (work) {
                    String answer = getRandomAnswer();
                    out.write("Бот: ");
                    out.write(answer);
                    System.out.println(answer);
                }
            }
            out.write("Вы:  ");
            out.write(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void loadAnswers() {
        try (PrintWriter out = new PrintWriter(new FileOutputStream(answers))) {
            String str;
            for (int i = 1; i < 6; i++) {
                str = "Ответ " + i + System.lineSeparator();
                out.write(str);
                answerList.add(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getUserMessage() {
        return new Scanner(System.in).nextLine();
    }

    private static String getRandomAnswer() {
        Random rand = new Random();
        return answerList.get(rand.nextInt(answerList.size()));
    }
}
