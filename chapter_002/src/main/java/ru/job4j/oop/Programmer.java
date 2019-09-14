package ru.job4j.oop;

public class Programmer extends Engineer {
    private String level;

        public Programmer (String level){
            this.level = level;
        }

        public String getLevel() {
            return this.level;
        }

        public void code() {
        }
}
