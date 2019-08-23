package ru.job4j.array;

/**
 * Class Класс проверки начала слова на определенную комбинацию символов
 * @author Mikhail Cherednichenko (28explay@gmail.com)
 * @since  23.08.2019
 * @version 1
 */

public class EndsWith {

    /**
     * Проверяет. что слово начинается с префикса.
     * @param post префикс.
     * @param word слово
     * @return true если слово заканчивается постфиксом, false если нет
     */

    public boolean endsWith(String word, String post) {
        boolean result = true;
        char[] pst = post.toCharArray();
        char[] wrd = word.toCharArray();
        for (int i = wrd.length - pst.length; i != wrd.length; i++){
            if (wrd[i] != pst[i - pst.length - 1]){
                result = false;
                break;
            }
        }
        return result;
    }
}