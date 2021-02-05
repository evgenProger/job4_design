package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LogFilter {
    public static List<String> filter(String file) throws IOException {
        List<String> res = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            for (String line = in.readLine(); line != null; line = in.readLine()) {
                String[] arr = line.split(" ");
                if (arr[arr.length - 2].equals("404")) {
                    res.add(line);
                }
            }
        }
        return res;
    }

    public static void save(List<String> log, String file) throws IOException {
        log.addAll(LogFilter.filter(file));
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(new FileOutputStream("logging.txt")))) {
            for (String s : log ) {
                out.write(s);
                out.write("\n");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        List<String> log = filter("log.txt");
        save(log, "log.txt");
        System.out.println(log);
    }
}
