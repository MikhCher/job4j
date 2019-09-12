package ru.job4j.oop;

public class Fox {
    public void tryEat(Ball kolobok) {
        System.out.println("Fox: kolobok, kolobok, I'm going to eat you!");
        kolobok.talk();
        kolobok.sing();
        System.out.println("Fox: What a wonderful song! Can you sing it being in my mouth?");
        kolobok.sing();
        System.out.println("Fox: Oh, such tasty that ball was!");
    }
}
