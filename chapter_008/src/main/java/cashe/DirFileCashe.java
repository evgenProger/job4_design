package cashe;

import java.io.*;
import java.lang.ref.SoftReference;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class DirFileCashe extends AbstractCashe<String, String> {
    private final String cachingDir;

    public DirFileCashe(String cachingDir) {
        this.cachingDir = cachingDir;
    }


    @Override
    protected String load(String key) throws IOException {
        String value = this.get(key);
        if (value == null) {
            value = Files.lines(Paths.get(cachingDir + File.separator +  key), StandardCharsets.UTF_8).collect(Collectors.joining());
            this.put(key, value);
        }
        return value;
    }
}
