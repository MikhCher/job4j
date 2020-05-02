package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RandomBot {

    private static final Logger LOG = LoggerFactory.getLogger(RandomBot.class.getName());

    private static final List<String> answerList = new ArrayList<>();

    private static final String CONTINUE = "продолжить";
    private static final String STOP = "стоп";
    private static final String END = "закончить";

    private static File answers;
    private static File log;

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
            LOG.error("Exception in writing data to log file", e);
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
            LOG.error("Exception in loading answers" , e);
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
