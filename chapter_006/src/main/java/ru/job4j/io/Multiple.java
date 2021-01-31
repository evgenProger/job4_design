package ru.job4j.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Objects;

public class Multiple {
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                table[i][j] = (i + 1) * (j + 1);

            }
        }
        return table;
    }
    public void recInFile( int[][] table ) throws IOException {
        StringBuilder str = new StringBuilder();
        try (FileOutputStream out = new FileOutputStream("table.txt")) {
            for (int i = 0; i < table.length; i++) {
                for (int j = 0; j < table.length; j++) {
                    int arr = table[i][j];
                    str.append(arr).append("\t");
                }
                out.write(str.toString().getBytes(StandardCharsets.UTF_8));
                out.write("\n".getBytes(StandardCharsets.UTF_8));
                str = new StringBuilder();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Multiple multiple = new Multiple();
        int table[][] = multiple.multiple(9);
        multiple.recInFile(table);
    }
}
