package ru.job4j.io.duplicates;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class FilePropertyFinder extends SimpleFileVisitor<Path> {
    Set<FileProperty> filePropertyList = new HashSet<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty property = new FileProperty(file.toFile().length(), file.getFileName().toString());
        if (filePropertyList.contains(property)) {
            System.out.println(file.getFileName() + " " +  "This is duplicate");
        } else {
            filePropertyList.add(property);
        }

        return super.visitFile(file, attrs);
    }

    public static void main(String[] args) throws IOException {
        Path start = Paths.get("C:\\projects\\job4j_design");
        Files.walkFileTree(start, new FilePropertyFinder());

    }
}
