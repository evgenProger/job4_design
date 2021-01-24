package ru.job4j.collection.email;

import java.util.*;

public class Email {



    public HashMap<String, Set<String>> unionEmails(HashMap<String, List<String>> email_accounts) {
        Map<String, Set<String>> res = new HashMap<>();
        List<String> users = new ArrayList<>();
        users.addAll(email_accounts.keySet());
        String user = null;
        Set<String> emails = new HashSet<>();
        List<String> next = new ArrayList<>();
        List<String> previous = new ArrayList<>();
        List<String> total = new ArrayList<>();
        Boolean flag = false;
        int i = 0;
        int j = 1;
        int k = 0;

        while (i < users.size()) {
            user = users.get(i);
            res.put(user, (Set<String>) email_accounts.get(users.get(i)));
            previous.addAll(res.get(user));
            next.addAll(email_accounts.get(users.get(j)));
            for (int m = 0; m < previous.size(); m++) {
                for (int n = 0; n < next.size(); n++) {
                    if (previous.get(m).equals(next.get(n))) {
                        res.get(user).addAll(next);
                        i++;
                        flag = true;

                        break;
                    }
                    else {

                    }
                }
                if (flag) {
                    break;
                }
            }
        }
        return (HashMap<String, Set<String>>) res;
    }

}


