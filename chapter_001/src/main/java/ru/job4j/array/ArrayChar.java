package ru.job4j.array;

/**
 * Class Класс проверки начала слова на определенную комбинацию символов
 * @author Mikhail Cherednichenko (28explay@gmail.com)
 * @since  23.08.2019
 * @version 1
 */

public class ArrayChar {

    /**
     * Проверяет, что слово начинается с префикса.
     * @param prefix префикс.
     * @param word слово
     * @return true если слово начинаеться с префикса, false если нет
     */
    public boolean startsWith(String word, String prefix) {
        boolean result = true;
        char[] pref = prefix.toCharArray();
        char[] wrd = word.toCharArray();
        for (int i = 0; i < pref.length; i++){
            if (pref[i] != wrd[i]){
                result = false;
                break;
            }
        }
        return result;
    }
}