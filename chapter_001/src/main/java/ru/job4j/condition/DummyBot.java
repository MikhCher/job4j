package ru.job4j.condition;

public class DummyBot {
    /**
     * Отвечает на вопросы.
     * @param question Вопрос от клиента.
     * @return Ответ.
     */
    public String answer(String question) {
        String rsl = "Это ставит меня в тупик. Задайте другой вопрос.";
        if ("Привет, Бот.".equals(question)) {
            rsl = "Привет, умник.";
            System.out.println(rsl);
        } else if ("Пока.".equals(question)) {
            rsl = "До скорой встречи.";
            System.out.println(rsl);
        }
        return rsl;
    }
}
