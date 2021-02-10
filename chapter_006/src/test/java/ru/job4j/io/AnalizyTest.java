package ru.job4j.io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AnalizyTest {
    String ln = System.lineSeparator();
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();
    @Test
    public void whenReadFile() throws IOException {
        StringBuilder res = new StringBuilder();
        Analizy analizy = new Analizy();
        File target = folder.newFile("target");
        analizy.unavailable("./data/server", target.getAbsolutePath());
        try (BufferedReader read = new BufferedReader(new FileReader(target.getAbsolutePath()))) {
            for (String line = read.readLine(); line != null; line = read.readLine()) {
                res.append(line).append(ln);
            }
        }
        assertThat(res.toString(), is("10:57:01;10:59:01" + ln + "11:01:02;11:02:02" + ln));
    }
}