import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Shell {
    private  List<String> res = new ArrayList<>();
    private String str;

    public void cd (String path) {
        if (path.equals("/")) {
            str = path;
            return;
        }
        String[] arr = path.split("/");
        res.addAll(Arrays.asList(arr));
    }

    public String pwd() {
        StringBuilder sb = new StringBuilder();
        if (str != null && str.equals("/")) {
            return str;
        }
        if (res.get(0).equals("")) {
            res.remove(0);
        }
        if (res.get(res.size() - 1).equals("..") && res.size() <= 2) {
            return "/";
        }
        if (res.get(res.size() - 1).equals("..")) {
            for (int i = 0; i < res.size() - 2; i++) {
                sb.append("/").append(res.get(i));
            }
        }
        else {
            for (int i = 0; i < res.size(); i++) {
                sb.append("/").append(res.get(i));
            }
        }
        str = sb.toString();
        return str;
    }
}
