package ru.job4j.collection.hashtable;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class HashTableTest  {
   @Test
    public void whenAdd() {
      HashTable<String, Integer> array = new HashTable<>(16);
      array.add("Evgeny", 28);
      assertFalse(array.add("Evgeny", 25));
   }
   @Test
   public void whenAddThenGet() {
      HashTable<String, Integer> array = new HashTable<>(16);
      array.add("Evgeny", 25);
      array.add("Bob", 28);
      Integer res = array.get("Evgeny");
      assertThat(res, is(25));
   }
   @Test
   public void whenHashMapFullThenResize() {
      HashTable<String, Integer> array = new HashTable<>(2);
      array.add("Evgeny", 25);
      array.add("Bob", 28);
      array.add("Lena", 31);
      Integer res = array.getCapacity();
      assertThat(res, is(4));
   }
   @Test
   public void whenInsertThenTrue() {
      HashTable<String, Integer> array = new HashTable<>(16);
      array.add("Evgeny", 28);
      assertTrue(array.insert("Evgeny", 25));
   }
   @Test
   public void whenInsertThenNewValue() {
      HashTable<String, Integer> array = new HashTable<>(16);
      array.add("Evgeny", 28);
      array.insert("Evgeny", 25);
      Integer res = array.get("Evgeny");
      assertThat(res, is(25));
   }
   @Test
   public void whenDelete() {
      HashTable<String, Integer> array = new HashTable<>(16);
      array.add("Evgeny", 25);
      array.add("Bob", 28);
      assertTrue(array.delete("Evgeny"));
   }
   @Test
   public void whenInsertThenIterator() {
      HashTable<String, Integer> array = new HashTable<>(16);
      array.insert("Evgeny", 25);
      HashTableItem<String, Integer> res = array.iterator().next();
      assertThat(res.value, is(25));

   }









}