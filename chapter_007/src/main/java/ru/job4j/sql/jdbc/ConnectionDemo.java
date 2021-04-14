package ru.job4j.sql.jdbc;

import java.io.*;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import ru.job4j.io.Config;

public class ConnectionDemo {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Config config = new Config("chapter_007/src/main/resources/app.properties");
        config.load();
        String driver = config.value("driver");
        Class.forName(driver);
        String url = config.value("url");
        String login = config.value("login");
        String password = config.value("password");
        try (Connection connection = DriverManager.getConnection(url, login, password)) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getUserName());
            System.out.println(metaData.getURL());
        }
    }
}


