import java.util.HashMap;
import java.util.Map;

public class ArgsSearch {
    private final String[] args;
    private HashMap<String, String> arguments;

    public ArgsSearch(String[] args) {
        arguments = (HashMap<String, String>) fillingMap();
        this.args = args;
    }


    public Map<String, String> fillingMap() {
        arguments = new HashMap<>();
        if (args.length % 2 != 0) {
            throw new IllegalArgumentException("Not all arguments");
        }
        for (int i = 0; i < args.length - 1; i += 2) {
            arguments.put(args[i], args[i + 1]);
        }
        return arguments;
    }

    public boolean valid() {
        return arguments.size() < 4;
    }

    public String directory() {
        return arguments.get("-d");
    }

    public String name()  {
        return arguments.get("-n");
    }

    public String type() { return arguments.get("-t"); }

    public String output() {
        return arguments.get("-o");
    }


}
