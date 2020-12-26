package ru.job4j.collection.hashtable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HashTable<K, V> {

   private int capacity = 16;
   private int size;

    public HashTable() {
        ArrayList<HashTable<K, V>>[] array =  new ArrayList[capacity];
    }

}
