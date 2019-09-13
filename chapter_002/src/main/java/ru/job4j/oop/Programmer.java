package ru.job4j.oop;

public class Programmer extends Engineer {
        public String level;

        public Programmer (String name, String surname, String education, int experience, String level){
            this.name = name;
            this.surname = surname;
            this.education = education;
            this.experience = experience;
            this.level = level;
        }

        public String getLevel() {
            return this.level;
        }

        public void code() {
        }
}
