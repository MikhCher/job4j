package ru.job4j.oop;

public class BallStory {
    public static void main(String[] args) {
        Ball kolobok = new Ball();
        Hare hare = new Hare();
        Wolf wolf = new Wolf();
        Fox fox = new Fox();
        hare.tryEat(kolobok);
        kolobok.sing();
        wolf.tryEat(kolobok);
        kolobok.sing();
        fox.tryEat(kolobok);
    }
}
