package ru.job4j.io;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.io.*;

public class Analizy {
    public void unavailable(String source, String target) throws IOException {
        int i = 0, j = 0;
        StringBuilder str = new StringBuilder();
        try (PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(target)))) {
            try (BufferedReader in = new BufferedReader(new FileReader(source))) {
                for (String line = in.readLine(); line != null; line = in.readLine()) {
                    if (line.startsWith("400") || line.startsWith("500")) {
                        while (!(line.startsWith("400") || line.startsWith("500"))) {
                            if (line.startsWith("400") || line.startsWith("400")) {
                                break;
                            }
                            str.append(line.substring(4)).append(";");
                            out.write(str.toString());
                            out.write("\n");
                        }
                    }

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
