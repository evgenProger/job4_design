package ru.job4j.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class EvenNumberFile {
    public static void main(String[] args) throws IOException {
        try (FileInputStream in = new FileInputStream("even.txt")) {
            int read;
            while ((read = in.read()) != -1) {
                if (Character.getNumericValue(read)  % 2 == 0) {
                    System.out.println("Yes");
                }
            }
        }
    }
}


