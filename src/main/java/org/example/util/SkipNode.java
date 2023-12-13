package org.example.util;
class SkipNode<K extends Comparable<K>, V> {
    K key;
    V value;
    SkipNode<K, V>[] forward;

    public SkipNode(K key, V value, int level) {
        this.key = key;
        this.value = value;
        this.forward = new SkipNode[level + 1];
    }
}