package ru.job4j.io.archiving;

import ru.job4j.io.Search;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    ArgZip argZip;

    public Zip(ArgZip argZip) {
        this.argZip = argZip;
        if (argZip.valid()) {
            throw new IllegalArgumentException("Not all arguments");
        }
    }

    public void packFiles() throws IOException {
        Search.SearchFiles searchFiles  = new Search.SearchFiles(path -> !path.toString().endsWith(argZip.exclude()));
        Files.walkFileTree(Paths.get(argZip.directory()), searchFiles);
        List<Path> source = searchFiles.getPaths();
        packSingleFile(source, new File(argZip.output()));
    }

    public void packSingleFile(List<Path> source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (Path path: source) {
                zip.putNextEntry(new ZipEntry(path.toString()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(path.toString()))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ArgZip argZip = new ArgZip(args);
        Zip zip = new Zip(argZip);
        zip.packFiles();
    }
}
