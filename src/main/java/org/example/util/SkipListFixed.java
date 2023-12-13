package org.example.util;

import java.util.Map;
import java.util.Random;

public class SkipListFixed<K extends Comparable<K>, V> implements SkipList<K, V> {
    private int level;
    private static final int Max_Level = 5;
    private SkipNode<K, V> head;

    public SkipListFixed() {
        this.level = 0;
        this.head = new SkipNode<>(null, null, 2);
    }

    @Override
    public void remove(K key) {
        SkipNode<K, V>[] update = new SkipNode[Max_Level + 1];
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

    public void insert(K key, V value) {
        SkipNode<K, V>[] update = new SkipNode[head.forward.length];
        SkipNode<K, V> current = head;

        for (int i = level; i >= 0; i--) {
            while (current.forward[i] != null && current.forward[i].key.compareTo(key) < 0) {
                current = current.forward[i];
            }
            update[i] = current;
        }

        int newLevel = Math.min(level + 1, head.forward.length - 1);  // Fixed size of 2
        for (int i = 0; i <= newLevel; i++) {
            SkipNode<K, V> newNode = new SkipNode<>(key, value, newLevel);
            newNode.forward[i] = update[i] != null ? update[i].forward[i] : null;

            if (update[i] != null) {
                update[i].forward[i] = newNode;
            }
        }

        level = newLevel;
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
}


