package org.example.util;

import java.util.Random;

public class SkipListRandom<K extends Comparable<K>, V> implements SkipList<K,V> {
    private static final int MAX_LEVEL = 5;
    private int level;
    private SkipNode<K, V> head;
    private final Random random;

    public SkipListRandom() {
        this.level = 0;
        this.head = new SkipNode<>(null, null, MAX_LEVEL);
        this.random = new Random();
    }

    public void insert(K key, V value) {
        SkipNode<K, V>[] update = new SkipNode[MAX_LEVEL + 1];
        SkipNode<K, V> current = head;

        for (int i = level; i >= 0; i--) {
            while (current.forward[i] != null && current.forward[i].key.compareTo(key) < 0) {
                current = current.forward[i];
            }
            update[i] = current;
        }

        int newLevel = randomLevel();
        if (newLevel > level) {
            for (int i = level + 1; i <= newLevel; i++) {
                update[i] = head;
            }
            level = newLevel;
        }

        SkipNode<K, V> newNode = new SkipNode<>(key, value, newLevel);
        for (int i = 0; i <= newLevel; i++) {
            newNode.forward[i] = update[i].forward[i];
            update[i].forward[i] = newNode;
        }
    }
    public V search(K key) {
        SkipNode<K, V> current = head;

        for (int i = level; i >= 0; i--) {
            while (current.forward[i] != null && current.forward[i].key.compareTo(key) < 0) {
                current = current.forward[i];
            }
        }

        current = current.forward[0];
        if (current != null && current.key.compareTo(key) == 0) {
            return current.value;
        } else {
            return null;
        }
    }

    @Override
    public void remove(K key) {
        SkipNode<K, V>[] update = new SkipNode[MAX_LEVEL + 1];
        SkipNode<K, V> current = head;

        for (int i = level; i >= 0; i--) {
            while (current.forward[i] != null && current.forward[i].key.compareTo(key) < 0) {
                current = current.forward[i];
            }
            update[i] = current;
        }

        current = current.forward[0];

        if (current != null && current.key.compareTo(key) == 0) {
            for (int i = 0; i <= level; i++) {
                if (update[i].forward[i] != current) {
                    break;
                }
                update[i].forward[i] = current.forward[i];
            }

            // Adjust the level if the deleted node was the highest in the list
            while (level > 0 && head.forward[level] == null) {
                level--;
            }
        }
    }

    @Override
    public void print() {
        for (int i = level; i >= 0; i--) {
            SkipNode<K, V> current = head.forward[i];
            System.out.print("Level " + i + ": ");
            while (current != null) {
                System.out.print("(" + current.key + ", " + current.value + ") ");
                current = current.forward[i];
            }
            System.out.println();
        }
    }

    private int randomLevel() {
        int level = 0;
        while (random.nextDouble() < 0.5 && level < MAX_LEVEL) {
            level++;
        }
        return level;
    }
}

