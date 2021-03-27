import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;

public class MainSearch {
    ArgsSearch argsSearch;
    Searcher searcher;

    public MainSearch(ArgsSearch argsSearch) {
        this.argsSearch = argsSearch;
        if (argsSearch.valid()) {
            throw new IllegalArgumentException("Not all arguments");
        }
    }

    private String preparePattern(String mask) {
        return mask.replace(".", "\\.").replaceAll("\\*", ".*");
    }

    public List<Path> foundInList() throws IOException {
        List<Path> foundFiles;
        if (argsSearch.type().equals("name")) {
            searcher = searchByName();
        } else if (argsSearch.type().equals("mask")) {
            searcher = searchByRegex(preparePattern(argsSearch.name()));
        } else {
            searcher = searchByRegex(argsSearch.name());
        }
        Files.walkFileTree(Paths.get(argsSearch.directory()), searcher);
        foundFiles = searcher.getPathList();
        return foundFiles;
    }

    private Searcher searchByRegex(String str) {
        Pattern pattern = Pattern.compile(str);
        return new Searcher(path -> pattern.matcher(path.getFileName().toString()).matches());
    }

    private Searcher searchByName() {
        return new Searcher(path -> path.getFileName().toString().equals(argsSearch.name()));
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
