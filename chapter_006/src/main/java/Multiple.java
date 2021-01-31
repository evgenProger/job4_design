import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

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

    public static void main(String[] args) {
        Multiple multiple = new Multiple();
        try (FileOutputStream out = new FileOutputStream("table.txt")) {
            out.write(Arrays.deepToString(multiple.multiple(3)).getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
