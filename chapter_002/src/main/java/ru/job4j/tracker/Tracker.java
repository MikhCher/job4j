package ru.job4j.tracker;

import java.awt.im.spi.InputMethod;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tracker {
    private List<Item> items = new ArrayList<>();
    private int position = 0;

    public Item add(Item item) {
        item.setId(this.generateId());
        items.add(item);
        return item;
    }

    public boolean delete(String id) throws IllegalStateException {
        boolean result = false;
        for (Item count : items) {
            if (count.getId().equals(id)) {
                result = true;
                items.remove(count);
                break;
            }
        }
        if (!result) {
            throw new IllegalStateException("There is no such ID");
        }
        return result;
    }

    public List<Item> findAll() {
        return items;
    }

    public List<Item> findByName(String key) {
        List<Item> rst = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(key)) {
                rst.add(item);
            }
        }
        return rst;
    }

    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    public boolean replace(String id, Item item) throws IllegalStateException {
        boolean result = false;
        for (Item count : items) {
            if (count.getId().equals(id)) {
                count.setName(item.getName());
                result = true;
            }
        }
        if (!result) {
            throw new IllegalStateException("There is no such ID");
        }
        return result;
    }

    private String generateId() {
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }
}
