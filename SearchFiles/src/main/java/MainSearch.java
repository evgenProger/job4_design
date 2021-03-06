import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class MainSearch {
    ArgsSearch argsSearch;
    Searcher searcher;

    public MainSearch(ArgsSearch argsSearch) {
        this.argsSearch = argsSearch;
        if (argsSearch.valid()) {
            throw new IllegalArgumentException("Not all arguments");
        }
    }

    public List<Path> foundInList() throws IOException {
        List<Path> foundFiles;
        if (argsSearch.type().equals("name")) {
            searcher = new Searcher(path -> path.getFileName().toString().equals(argsSearch.name()));

        } else if (argsSearch.type().equals("mask")) {
            if (argsSearch.name().startsWith("*")) {
                if (argsSearch.name().endsWith("*")) {
                    searcher = new Searcher(path -> path.getFileName().toString().contains(argsSearch.name().replaceAll("\\*", "")));
                } else {
                    searcher = new Searcher(path -> path.getFileName().toString().endsWith(argsSearch.name().replaceAll("\\*", "")));
                }

            } else if (argsSearch.name().endsWith("*")) {
                searcher = new Searcher(path -> path.getFileName().toString().startsWith(argsSearch.name().replaceAll("\\*", "")));
            }
        }
        Files.walkFileTree(Paths.get(argsSearch.directory()), searcher);
        foundFiles = searcher.getPathList();
        return foundFiles;
    }

    public void recInFile() throws IOException {
        List<Path> res = foundInList();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(argsSearch.output()))) {
            for (Path path: res) {
                writer.write(path.toAbsolutePath().toString());
                writer.newLine();

            }
        }
    }

    public static void main(String[] args) throws IOException {
        ArgsSearch argsSearch = new ArgsSearch(args);
        MainSearch mainSearch = new MainSearch(argsSearch);
        mainSearch.recInFile();

    }
}
