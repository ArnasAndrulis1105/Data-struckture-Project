package org.example.util;

public interface SkipList<K extends Comparable<K>, V>{
    int LEVELS = 5;
    void remove(K key);
    void insert(K key ,V value);
    void print();
    V search(K key);
}
