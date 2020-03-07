package ru.job4j.map;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class HashMap<K, V> implements Iterable<K> {
    private int size = 2;
    private int count = 0;
    private Node[] hashTable = new Node[size];

    private class Node<K, V> {
        private K key;
        private V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }

    private int hash(K key) {
        int h;
        if (key == null) {
            h = 0;
        } else {
            h = key.hashCode();
            h = h ^ (h >>> 16);
        }
        return h;
    }

    private int indexFor(int hash) {
        return hash & (hashTable.length - 1);
    }

    public boolean insert(K key, V value) {
        boolean result = false;

        if (count == hashTable.length) {
            grow();
        }

        int position = indexFor(hash(key));

        if (hashTable[position] == null) {
            hashTable[position] = new Node(key, value);
            count++;
            result = true;
        }
        return result;
    }

    public V get(K key) {
        return (V) hashTable[indexFor(hash(key))].value;
    }

    public boolean delete(K key) {
        int position = indexFor(hash(key));
        hashTable[position] = null;
        return hashTable[position] == null;
    }

    private void grow() {
        Node[] oldArray = hashTable;
        hashTable = new Node[size * 2];
        size *= 2;
        for (Node node : oldArray) {
            if (node != null) {
                K key = (K) node.key;
                V value = (V) node.value;
                int hash = hash(key);
                hashTable[indexFor(hash)] = new Node(key, value);
            }
        }
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            int cursor = 0;
            @Override
            public boolean hasNext() {
                return cursor < hashTable.length;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                K key;
                if (hashTable[cursor] == null) {
                    key = null;
                } else {
                    key = (K) hashTable[cursor].key;
                }
                cursor++;
                return key;

            }
        };
    }
}
