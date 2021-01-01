package ru.job4j.collection.hashtable;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class HashTableTest  {
   @Test
    public void whenInsert() {
       HashTable<String, Integer> array = new HashTable<>();
       array.insert("Evgeny", 25);
       array.insert("Bob", 28);
       assertFalse(array.insert("Evgeny", 29));
   }
   @Test
   public void whenInsertThenGet() {
      HashTable<String, Integer> array = new HashTable<>();
      array.insert("Evgeny", 25);
      array.insert("Bob", 28);
      Integer res = array.get("Evgeny");
      assertThat(res, is(25));
   }
   @Test
   public void whenHashMapFullThenResize() {
      HashTable<String, Integer> array = new HashTable<>();
      array.insert("Evgeny", 25);
      array.insert("Bob", 28);
      array.insert("Lena", 31);
      Integer res = array.getCapacity();
      assertThat(res, is(4));
   }
   @Test
   public void whenDelete() {
      HashTable<String, Integer> array = new HashTable<>();
      array.insert("Evgeny", 25);
      array.insert("Bob", 28);
      assertTrue(array.delete("Evgeny"));
   }
   @Test
   public void whenInsertThenIterator() {
      HashTable<String, Integer> array = new HashTable<>();
      array.insert("Evgeny", 25);
      HashTableItem<String, Integer> res = array.iterator().next();
      assertThat(res.value, is(25));

   }









}