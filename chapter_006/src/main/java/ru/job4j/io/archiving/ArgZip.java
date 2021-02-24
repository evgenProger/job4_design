package ru.job4j.io.archiving;

import ru.job4j.io.ArgsName;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class ArgZip  {
    private final String[] args;
    HashMap<String, String> values;

    public ArgZip(String[] args) {
        this.args = args;
        values = (HashMap<String, String>) fillingMap();
    }

    public Map<String, String> fillingMap() {
      values = new HashMap<>();
      if (args.length % 2 != 0) {
          throw new IllegalArgumentException();
      }
          for (int i = 0; i < args.length - 1; i += 2) {
              values.put(args[i], args[i + 1]);
          }
          return values;
    }

    public boolean valid() {
        return values.size() < 3;
    }

    public String directory() {
        return values.get("-d");
    }

    public String exclude()  {
        return values.get("-e");
    }

    public String output() {
        return values.get("-o");
    }
}
