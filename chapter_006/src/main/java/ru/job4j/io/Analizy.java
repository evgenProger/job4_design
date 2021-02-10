package ru.job4j.io;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.io.*;

public class Analizy {
    public void unavailable(String source, String target) throws IOException {
        String ln = System.lineSeparator();
        StringBuilder str = new StringBuilder();
        try (PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(target)))) {
            try (BufferedReader in = new BufferedReader(new FileReader(source))) {
                        String line = in.readLine();
                        while (line != null) {
                            if (line.startsWith("400") || line.startsWith("500")) {
                                str.append(line.substring(4)).append(";");
                                while (line.startsWith("400") || line.startsWith("500") || line.isEmpty()) {
                                    line = in.readLine();
                                }
                                str.append(line.substring(4)).append(ln);
                                out.write(str.toString());
                            }
                            line = in.readLine();
                            str = new StringBuilder();
                        }
            }
        }
    }

    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
