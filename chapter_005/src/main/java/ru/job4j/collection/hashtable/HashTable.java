package ru.job4j.collection.hashtable;

import java.util.*;

public class HashTable<K, V> implements Iterable<HashTableItem<K, V>> {
    private HashTableItem[] array;
    private int capacity = 16;
   private int size;
   private int modcount = 0;
   private final double LOAD_FACTOR = 0.75;

    public HashTable() {
        array =  new HashTableItem[capacity];
    }


     public boolean insert(K key, V value) {
         modcount++;
         boolean res = false;
         if (getLOAD_FACTOR() >= LOAD_FACTOR) {
             this.resize();
         }
         HashTableItem<K, V> tableItem = new HashTableItem<>(key, value);
        int index = key.hashCode() % capacity;
        if (array[index] != null) {
            return res;
        }
            array[index] = tableItem;
            size++;
            res = true;

        return res;
     }

     private double getLOAD_FACTOR() {
        return size / capacity;
    }

    private void resize() {
        capacity = capacity * 2;
        var oldArray = array;
        size = 0;
        array = new HashTableItem[capacity];
        for (var item: oldArray) {
            if (item != null) {
              this.insert((K) item.key, (V) item.value);
            }
        }
    }

     public V get(K key) {
        int index = key.hashCode() % capacity;
        return  (V) array[index].getValue();

     }

     public boolean delete(K key) {
        boolean flag = false;
        int index = key.hashCode() % capacity;
        if (array[index] != null) {
            array[index].key = null;
            array[index].value = null;
            flag = true;
            size--;
        }
        return flag;
     }


    public int getCapacity() {
        return capacity;
    }

    @Override
    public Iterator<HashTableItem<K, V>> iterator() {
        Iterator<HashTableItem<K, V>> it = new Iterator<>() {
            int currentIndex = 0;
            int expectedModCount = modcount;

            @Override
            public boolean hasNext() {
                while (array[currentIndex] == null) {
                    currentIndex++;
                }
                return currentIndex < capacity;
            }

            @Override
            public HashTableItem<K, V> next() {
                if (!hasNext()) {
                    throw  new NoSuchElementException();
                }
                if (expectedModCount != modcount) {
                    throw new ConcurrentModificationException();
                }
                return array[currentIndex];

            }

        };
        return it;

    }
}
