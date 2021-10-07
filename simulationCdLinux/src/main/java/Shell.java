import java.util.LinkedList;

public class Shell {
    private LinkedList<String> res = new LinkedList<>();

    public void cd(String path) {
        String[] str;
        str = path.split("/");
        for (int i = 0; i < str.length; i++) {
            if (str[i].equals("")) {
                continue;
            }
            if (!str[i].equals("..")) {
                res.addLast(str[i]);
            } else {
                res.pollLast();
            }

        }
    }


    public String pwd() {
            return "/" + String.join("/", res);

      /*  StringBuilder sb = new StringBuilder();
        while (!res.isEmpty()) {
            sb.append(res.pollFirst());
        }
        return sb.toString();
       */
    }


}







