package cashe;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class DirFileCashTest {
    @Test
    public void whenLoadThenGetContent() throws IOException {
        DirFileCash dirFileCash = new DirFileCash("/home/evgeny/job4_design/chapter_008/Dir");
        String res = dirFileCash.load("Names.txt");
        StringBuilder sb = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader("/home/evgeny/job4_design/chapter_008/Dir/Names.txt"))) {
            for (String line = in.readLine(); line != null; line = in.readLine()) {
                sb.append(line);
            }
        }
        String expect = sb.toString();
        assertThat(res, is(expect));
    }

    @Test
    public void whenCasheIsEmptyThenLoad() throws IOException {
        AbstractCashe<String, String> dirFileCash = new DirFileCash("Dir");
        dirFileCash.get("Address.txt");
        String res = dirFileCash.get("Address.txt");
        String expect = Files.readString(Paths.get("Dir/Address.txt"));
        assertThat(res, is(expect));
    }
}