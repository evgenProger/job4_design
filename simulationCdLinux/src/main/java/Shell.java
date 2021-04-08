import java.util.LinkedList;

public class Shell {
    private LinkedList<String> res = new LinkedList<>();

    public void cd(String path) {
        StringBuilder sb = new StringBuilder();
        if (path.equals("/")) {
            res.addFirst(path);
            return;
        }
        String[] str;
        str = path.split("/");
        for (int i = 0; i < str.length; i++) {
            if (str[i].equals("")) {
                continue;
            }
            if (!str[i].equals("..")) {
                res.addLast(str[i]);
            }
            else {
                res.pollFirst();
            }

        }
    }




       /* StringBuilder str = new StringBuilder();
        if (path.equals("/")) {
            res.addFirst(path);
            return;
        }
        if (!path.endsWith("..")) {
            str.append("/").append(path);
            res.addLast(str.toString());
        }
        if (path.endsWith("..") && res.isEmpty()) {
            str = new StringBuilder(path.substring(0, path.lastIndexOf("/")));
            str = new StringBuilder(str.substring(0, str.lastIndexOf("/") + 1));
            res.addFirst(str.toString());
            return;

        }
        if (path.endsWith("..") && !res.isEmpty() && res.size() <= 2) {
            str = new StringBuilder();
            while (!res.isEmpty()) {
                str.append(res.pollFirst());
                str.append(path);
            }
            str = new StringBuilder(str.substring(0, str.lastIndexOf("/") + 1));
            res.addFirst(str.toString());
        }
        else if (path.endsWith("..") && !res.isEmpty() && res.size() > 2){
            int count = 0;
            while (count < 2) {
                str.append(res.pollFirst());
                count++;
            }
            while (!res.isEmpty()) {
                res.poll();
            }
            res.addFirst(str.toString());
        }
    }
        */

    public String pwd() {
        StringBuilder sb = new StringBuilder();
        while (!res.isEmpty()) {
            sb.append(res.pollFirst());
        }
        return sb.toString();
    }
}







