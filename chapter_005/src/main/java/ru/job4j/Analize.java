package ru.job4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Analize {

    public Info diff(List<User> previous, List<User> current) {
        Info info = new Info();
        Map<Integer, String> previousMap = new HashMap<>();
        Map<Integer, String> currentMap = new HashMap<>();

        fillMap(previousMap, previous);
        fillMap(currentMap, current);

        for (Integer id : previousMap.keySet()) {
            if (currentMap.containsKey(id) && !currentMap.get(id).equals(previousMap.get(id))) {
                info.changed++;
            } else if (!currentMap.containsKey(id)) {
                info.deleted++;
            }
        }
        previousMap.keySet().retainAll(currentMap.keySet());
        info.added = currentMap.size() - previousMap.size();
        return info;

    }

    private void fillMap(Map<Integer, String> map, List<User> list) {
        for (User user : list) {
            map.put(user.id, user.name);
        }
    }

    public static class User {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    public static class Info {

        int added = 0;
        int changed = 0;

        int deleted = 0;

    }

}