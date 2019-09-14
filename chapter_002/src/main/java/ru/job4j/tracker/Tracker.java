package ru.job4j.tracker;

import java.util.Random;

public class Tracker {
    private Item[] items = new Item[100];
    private int position = 0;

    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    public boolean delete(String id) {
        boolean result = false;
        Item[] deleted = new Item[--this.position];
        for (int i = 0; i < this.position; i++) {
            if (items[i].getId().equals(id)) {
                System.arraycopy(items, 0, deleted, 0, i);
                System.arraycopy(items, i + 1, deleted, i, this.position - 1);
                result = true;
                break;
            }
        }
        return result;
    }

    public Item[] findAll() {
        Item[] all = new Item[this.position];
        System.arraycopy(items, 0, all, 0, this.position);
        return all;
    }

    public Item[] findByName(String key) {
        Item[] result = new Item[this.position];
        int coincidence = 0;
        for (int i = 0; i < this.position; i++) {
             if (items[i].getName().equals(key)) {
                 System.arraycopy(items, i, result, coincidence++, 1);
             }
        }
        return result;
    }

    public Item findById(String id) {
        Item result = null;
        for (int i = 0; i < this.position; i++) {
            if (items[i].getId().equals(id)) {
                result = items[i];
                break;
            }
        }
        return result;
    }

    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int i = 0; i < this.position; i++) {
            if (items[i].getId().equals(id)) {
                items[i] = item;
                result = true;
            }
        }
        return result;
    }

    private String generateId () {
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }
}
