package ru.job4j.template;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class ProducerTest {
    @Test
    public void whenHasTemplateThenGetString() {
        Producer producer = new Producer();
        Map<String, String> data = new HashMap<>();
        String temp =  "Who are ${subject}? I am a ${name}";
        data.put("name", "Evgeniy Ivanov");
        data.put("subject", "you");
        String expect = "Who are You? I am Evgeniy Ivanov";
        String result = producer.produce(temp, data);
        assertEquals(expect, result);
    }

    @Test(expected = NoSuchElementException.class)
    public void whenMapHasNotEnoughKeys() {
        Producer producer = new Producer();
        Map<String, String> data = new HashMap<>();
        String temp =  "Who are ${subject}? I am a ${name}";
        data.put("name", "Evgeniy Ivanov");
        producer.produce(temp, data);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenMapHasExcessKeys() {
        Producer producer = new Producer();
        Map<String, String> data = new HashMap<>();
        String temp = "Who are ${subject}?";
        data.put("name", "Evgeniy Ivanov");
        data.put("subject", "you");
        producer.produce(temp, data);
    }
}
