package ru.job4j.io;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ConfigTest {
    @Test
    public void whenPairWithoutComment() {
        String path = "C:\\projects\\job4j_design\\evgen";
        Config config = new Config(path);
        config.load();
        System.out.println(config.toString());
        assertThat(
                config.value("name"),
                is("Evgeny Ivanov")
        );
    }
    @Test
    public void whenPairWithComment() {
        String path = ".app,properties";
        Config config = new Config(path);
        config.load();
        System.out.println(config.toString());
        assertThat(
                config.value("hibernate.connection.url"),
                is("jdbc:postgresql://127.0.0.1:5432/trackstudio")
        );
    }


}