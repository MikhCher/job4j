package ru.job4j.oop;

public class Cat {

    private String food;
    private String name;

    public void giveNick(String nick) {
        this.name = nick;
    }
    public void show() {
        System.out.println(this.name);
        System.out.println(this.food);
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public static void main(String[] args) {
        System.out.println("This is the name and food of the first cat:");
        Cat first = new Cat();
        first.giveNick("Gav");
        first.eat("kotleta");
        first.show();
        System.out.println("This is the name and food of the second cat:");
        Cat second = new Cat();
        second.giveNick("Alex");
        second.eat("fish");
        second.show();
    }
}