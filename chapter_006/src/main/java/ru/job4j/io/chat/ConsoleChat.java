package ru.job4j.io.chat;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleChat {
    List<String> phrases = new ArrayList<>();
    private final String path;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() throws IOException {
        boolean res = true;
        String ln = System.lineSeparator();
        Scanner in = new Scanner(System.in);
        String word = in.nextLine();
        readPhrases();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(botAnswers))) {
            while (!OUT.equals(word)) {
                if (STOP.equals(word)) {
                    res = false;
                }
                if (CONTINUE.equals(word)) {
                    res = true;
                }
                writer.write(word + ln);
                if (res) {
                    String answer = getBotAnswers();
                    System.out.println(answer);
                    writer.write(answer + ln);
                }
                word = in.nextLine();
            }
            writer.write(word);
        }
    }

    public  void readPhrases() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                phrases.add(line);
            }
        }
    }
    public String getBotAnswers() {
        String phrase;
        phrase = phrases.get((int) (Math.random() * phrases.size()));
        return phrase;
    }

    public static void main(String[] args) throws IOException {
        ConsoleChat cc = new ConsoleChat("C:\\projects\\job4j_design\\chapter_006\\src\\main\\java\\ru\\job4j\\io\\chat\\phrases", "C:\\projects\\job4j_design\\chapter_006\\src\\main\\java\\ru\\job4j\\io\\chat\\log_dialogs.txt");
        cc.run();
    }
}
