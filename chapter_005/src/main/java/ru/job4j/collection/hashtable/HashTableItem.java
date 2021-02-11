package ru.job4j.collection.hashtable;

import java.util.Objects;

public class HashTableItem<K, V> {
    public K key;

    public V value;

    public HashTableItem(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public int hashCode() {
        return key.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this.key == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        K k = (K) obj;
        return Objects.equals(k, key);
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
