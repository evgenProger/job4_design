import java.util.LinkedList;

public class Shell {
    private LinkedList<String> res = new LinkedList<>();


    public void cd(String path) {
        StringBuilder str = new StringBuilder();
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
            res.addFirst(str.toString());
            res.pollLast();
        }

    }

    public String pwd() {
        StringBuilder sb = new StringBuilder();
        while (!res.isEmpty()) {
            sb.append(res.pollFirst());
        }
        return sb.toString();
    }
}


      /*  StringBuilder sb = new StringBuilder();
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

       */



