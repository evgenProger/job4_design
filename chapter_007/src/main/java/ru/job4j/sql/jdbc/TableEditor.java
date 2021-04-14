package ru.job4j.sql.jdbc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class TableEditor implements AutoCloseable {
    private Connection connection;
    private Properties properties;

    public TableEditor(Properties properties) throws SQLException, ClassNotFoundException {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() throws SQLException, ClassNotFoundException {
       String driver = properties.getProperty("driver");
       Class.forName(driver);
       String url = properties.getProperty("url");
       String login = properties.getProperty("login");
       String password = properties.getProperty("password");
       connection = DriverManager.getConnection(url, login, password);
    }

    public void createTable(String tableName) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String sql = String.format("create table %s (id serial primary key);", tableName);
            statement.execute(sql);
        }
    }

    public void dropTable(String tableName) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String sql = String.format("Drop table %s", tableName);
            statement.execute(sql);
        }
    }

    public void addColumn(String tableName, String columnName, String type) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String sql = String.format("ALTER table %s ADD %s %s", tableName, columnName, type);
            statement.execute(sql);
        }
    }

    public void dropColumn(String tableName, String columnName) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String sql = String.format("ALTER table %s DROP COLUMN %s", tableName, columnName);
            statement.execute(sql);
        }
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String sql = String.format("ALTER TABLE %s RENAME %s TO %s", tableName, columnName, newColumnName);
            statement.execute(sql);
        }

    }

    public String getScheme(String tableName) throws SQLException {
        StringBuilder scheme = new StringBuilder();
        DatabaseMetaData metaData = connection.getMetaData();
        try (ResultSet columns = metaData.getColumns(null, null, tableName, null)) {
            scheme.append(String.format("%-15s %-15s%n", "column", "type"));
            while (columns.next()) {
                scheme.append(String.format("%-15s %-15s%n",
                        columns.getString("COLUMN_NAME"),
                        columns.getString("TYPE_NAME")));
            }
        }
        return scheme.toString();
    }

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
       FileReader reader = new FileReader("chapter_007/src/main/resources/app.properties");
       Properties properties = new Properties();
       properties.load(reader);
       TableEditor tableEditor = new TableEditor(properties);
       tableEditor.renameColumn("mytable", "id", "name");
        System.out.println(tableEditor.getScheme("mytable"));
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
}
