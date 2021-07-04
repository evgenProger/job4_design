package cashe;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class DirFileCashTest {
    @Test
    public void whenLoadIntoCashThenGetContent() throws IOException {
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
}