package ru.job4j.bank;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BankTest {

    @Test
    public void whenAddUserAccount() {
        Bank bank = new Bank();
        User user = new User("Sergey", "5313356650");
        Account account = new Account(5358, "89096042629");
        bank.addUser(user);
        bank.addAccountToUser(user.getPassport(), account);
        int result = bank.getUserAccounts(user.getPassport()).size();
        int expect = 1;
        assertThat(result, is(expect));
    }

    @Test
    public void whenDeleteUserAccount() {
        Bank bank = new Bank();
        User user = new User("Sergey", "5313356650");
        Account account = new Account(5358, "89096042629");
        bank.addUser(user);
        bank.addAccountToUser(user.getPassport(), account);
        bank.deleteAccountFromUser(user.getPassport(), account);
        int result = bank.getUserAccounts(user.getPassport()).size();
        int expect = 0;
        assertThat(result, is(expect));
    }

    @Test
    public void whenAllFieldsCorrectTransfer() {
        Bank bank = new Bank();
        User first = new User("Onevsky", "5317808992");
        User second = new User("Mikhail", "4015281228");
        bank.addUser(first);
        bank.addUser(second);
        Account sber1 = new Account(2017, "6234412367");
        Account sber2 = new Account(501, "123412");
        Account vtb = new Account(5809, "2200317");
        bank.addAccountToUser(first.getPassport(), sber1);
        bank.addAccountToUser(first.getPassport(), sber2);
        bank.addAccountToUser(second.getPassport(), vtb);
        boolean result = bank.transferMoney(first.getPassport(), sber2.getReqs(), second.getPassport(), vtb.getReqs(), 251);
        assertTrue(result);
    }

    @Test
    public void whenIncorrectSourcePassportTransfer() {
        Bank bank = new Bank();
        User first = new User("Onevsky", "5317808992");
        User second = new User("Mikhail", "4015281228");
        bank.addUser(first);
        bank.addUser(second);
        Account sber1 = new Account(2017, "6234412367");
        Account sber2 = new Account(501, "123412");
        Account vtb = new Account(5809, "2200317");
        bank.addAccountToUser(first.getPassport(), sber1);
        bank.addAccountToUser(first.getPassport(), sber2);
        bank.addAccountToUser(second.getPassport(), vtb);
        boolean result = bank.transferMoney("0101", sber2.getReqs(), second.getPassport(), vtb.getReqs(), 251);
        assertFalse(result);
    }

    @Test
    public void whenIncorrectRequisitesTransfer() {
        Bank bank = new Bank();
        User first = new User("Onevsky", "5317808992");
        User second = new User("Mikhail", "4015281228");
        bank.addUser(first);
        bank.addUser(second);
        Account sber1 = new Account(2017, "6234412367");
        Account sber2 = new Account(501, "123412");
        Account vtb = new Account(5809, "2200317");
        bank.addAccountToUser(first.getPassport(), sber1);
        bank.addAccountToUser(first.getPassport(), sber2);
        bank.addAccountToUser(second.getPassport(), vtb);
        boolean result = bank.transferMoney(first.getPassport(), "228359", second.getPassport(), vtb.getReqs(), 251);
        assertFalse(result);
    }

    @Test
    public void whenNotEnoughMoneyTransfer() {
        Bank bank = new Bank();
        User first = new User("Onevsky", "5317808992");
        User second = new User("Mikhail", "4015281228");
        bank.addUser(first);
        bank.addUser(second);
        Account sber1 = new Account(2017, "6234412367");
        Account sber2 = new Account(501, "123412");
        Account vtb = new Account(5809, "2200317");
        bank.addAccountToUser(first.getPassport(), sber1);
        bank.addAccountToUser(first.getPassport(), sber2);
        bank.addAccountToUser(second.getPassport(), vtb);
        boolean result = bank.transferMoney(first.getPassport(), sber2.getReqs(), second.getPassport(), vtb.getReqs(), 729);
        assertFalse(result);
    }
}