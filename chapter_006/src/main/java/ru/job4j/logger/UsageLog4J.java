package ru.job4j.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4J {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4J.class.getName());

    public static void main(String[] args) {
        int a = 1;
        char b = 'c';
        boolean c = true;
        float d = 10;
        byte e = 2;
        short f = 3;
        long g = 4;
        double h = 5;
        LOG.debug("{} {} {} {} {} {} {} {}", a, b, c ,d ,e, f, g, h);
    }
}