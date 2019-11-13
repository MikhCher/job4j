package ru.job4j.bank;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        User desiredUser = getUserByPassport(passport);
        if (desiredUser != null) {
            map.get(desiredUser).add(account);
        }
    }

    // удалить один счёт пользователя.
    public void deleteAccountFromUser(String passport, Account account) {
        User desiredUser = getUserByPassport(passport);
        if (desiredUser != null) {
            Account desiredAccount = getAccount(passport, account.getReqs());
            map.get(desiredUser).remove(desiredAccount);
        }
    }

    // получить список счетов для пользователя.
    public List<Account> getUserAccounts(String passport) {
        User desiredUser = getUserByPassport(passport);
        return map.get(desiredUser);
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
        List<User> desiredUser = Stream.of(map.keySet())
                .flatMap(Set::stream)
                .filter(user -> user.getPassport().equals(passport))
                .collect(Collectors.toList());
        if (!desiredUser.isEmpty()) {
            List<Account> desiredAccount = map.get(desiredUser.get(0)).stream()
                .filter(account -> account.getReqs().equals(requisites))
                .collect(Collectors.toList());
            if (!desiredAccount.isEmpty()) {
                result = desiredAccount.get(0);
            }
        }
        return result;
    }

    private User getUserByPassport(String passport) {
        User result = null;
        List<User> desiredUser = Stream.of(map.keySet())
                .flatMap(Set::stream)
                .filter(user -> user.getPassport().equals(passport))
                .collect(Collectors.toList());
        if (!desiredUser.isEmpty()) {
            result = desiredUser.get(0);
        }
        return result;
    }
}