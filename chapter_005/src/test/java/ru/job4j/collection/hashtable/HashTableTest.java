package ru.job4j.collection.hashtable;
import org.junit.Test;
import static org.junit.Assert.*;

public class HashTableTest  {
   @Test
    public void whenInsert() {
       HashTable<String, Integer> array = new HashTable<>();
       array.insert("Evgeny", 25);
       array.insert("Bob", 28);
       assertFalse(array.insert("Evgeny", 29));
   }


}