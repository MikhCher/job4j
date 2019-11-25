package ru.job4j.lambda.mail;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserDataBase {
    private Map<User, List<String>> data = new TreeMap<>();

    public void squashUsers() {
       List<User> similarUsers = new ArrayList<>();
        List<User> result = data.keySet().stream()
                .filter(currentUser -> {
                    List<User> remainUsers = data.keySet().stream()
                            .dropWhile(user -> user != currentUser)
                            .skip(1)
                            .collect(Collectors.toList());
                    for (User user : remainUsers) {
                        if (data.get(user).stream().anyMatch(mail -> {
                            boolean similar = false;
                            for (String currentMail : data.get(currentUser)) {
                                if (currentMail.equals(mail)) {
                                    similar = true;
                                    break;
                                }
                            }
                            return similar;
                        })) {
                            List<String> newValue = new ArrayList<>(data.get(currentUser));
                            newValue.addAll(data.get(user));
                            newValue = newValue.stream().distinct().collect(Collectors.toList());
                            data.put(currentUser, newValue);
                            similarUsers.add(user);
                        }
                    }
                    return true;
                })
                .collect(Collectors.toList());
        List<User> deleteList = new ArrayList<>(similarUsers);
        deleteList = deleteList.stream().distinct().collect(Collectors.toList());
        for (User user : deleteList) {
            data.remove(user);
        }
    }

    public void addMailToUser(User user, List<String> mails) {
        data.get(user).addAll(mails);
    }

    public Map<User, List<String>> getMap() {
        return data;
    }

    public void setUsers(List<User> users) {
        for (User user : users) {
            data.put(user, new ArrayList<>());
        }
    }
}
