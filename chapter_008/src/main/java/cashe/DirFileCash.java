package cashe;

import java.io.*;
import java.lang.ref.SoftReference;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class DirFileCash extends AbstractCashe<String, String> {
    private final String cachingDir;

    public DirFileCash(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) throws IOException {
        String path = cachingDir + File.separator + key;
        String value = null;
        if (!this.cashe.containsKey(key)) {
            value = Files.lines(Paths.get(path), StandardCharsets.UTF_8).collect(Collectors.joining());
            this.put(key, value);
        }
        return value;
    }
}
