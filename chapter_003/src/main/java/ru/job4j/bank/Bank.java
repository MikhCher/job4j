package ru.job4j.bank;

import java.util.*;

public class Bank {
    private Map<User, ArrayList<Account>> map = new HashMap<>();

    // добавление пользователя.
    public void addUser(User user) {
        this.map.putIfAbsent(user, new ArrayList<>());
    }

    // удаление пользователя.
    public void deleteUser(User user) {
        this.map.remove(user);
    }

    // добавить счёт пользователю.
    public void addAccountToUser(String passport, Account account) {
        for (User user : map.keySet()) {
            if (user.getPassport().equals(passport)) {
                this.map.get(user).add(account);
                break;
            }
        }
    }

    // удалить один счёт пользователя.
    public void deleteAccountFromUser(String passport, Account account) {
        for (User user : map.keySet()) {
            if (user.getPassport().equals(passport)) {
                this.map.get(user).remove(account);
                break;
            }
        }
    }

    // получить список счетов для пользователя.
    public List<Account> getUserAccounts(String passport) {
        List<Account> result = new ArrayList<>();
        for (User user : map.keySet()) {
            if (user.getPassport().equals(passport)) {
                result.addAll(this.map.get(user));
            }
        }
        return result;
    }

    // метод для перечисления денег с одного счёта на другой счёт:
    // если счёт не найден или не хватает денег на счёте srcAccount (с которого переводят) должен вернуть false.
    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        Account source = getAccount(srcPassport, srcRequisite);
        Account destination = getAccount(destPassport, dstRequisite);
        boolean result = source != null && destination != null && source.getValue() > amount;
        if (result) {
            source.setValue(source.getValue() - amount);
            destination.setValue(destination.getValue() + amount);
        }
        return result;
    }

    private Account getAccount(String passport, String requisites) {
        Account result = null;
        for (User user : this.map.keySet()) {
            if (user.getPassport().equals(passport)) {
                for (Account account : this.map.get(user)) {
                    if (account.getReqs().equals(requisites)) {
                        result = account;
                        break;
                    }
                }
                break;
            }
        }
        return result;
    }
}