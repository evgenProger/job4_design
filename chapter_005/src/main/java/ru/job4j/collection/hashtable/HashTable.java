package ru.job4j.collection.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class HashTable<K, V> {
    private HashTableItem[] array;
   private int capacity = 16;
   private int size;
   private final double LOAD_FACTOR = 0.75;

    public HashTable() {
        array =  new HashTableItem[capacity];
    }


     public boolean insert(K key, V value) {
         boolean res = false;
         HashTableItem<K, V> tableItem = new HashTableItem<>(key, value);
        int index = key.hashCode() % capacity;
        if (array[index] != null) {
            return res;
        }
        else {
            if (size / capacity >= LOAD_FACTOR) {
                array = Arrays.copyOf(array, (int) (capacity * 1.5 + 1));
            }
            array[index] = tableItem;
            size++;
            res = true;
        }
        return res;
     }

     public V get(K key) {
        int index = key.hashCode();
        return  (V) array[index].getValue();

     }



}
