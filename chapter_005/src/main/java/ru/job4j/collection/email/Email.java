package ru.job4j.collection.email;

import java.util.*;

public class Email {



    public HashMap<String, List<String>> unionEmails(HashMap<String, List<String>> email_accounts) {
        Map<String, List<String>> res = new HashMap<>();
        List<String> result = new ArrayList<>();
        List<String> users = new ArrayList<>();
        Boolean flag = false;
        users.addAll(email_accounts.keySet());
        int p = 0;
        String user = null;
        Set<String> emails = new HashSet<>();
        List<String> next = new ArrayList<>();
        int i = 0;
        while (i < users.size()) {
            emails.addAll(email_accounts.get(users.get(i)));
            while (p < 2) {
                for (int j = i + 1; j < users.size(); j++) {
                    next.addAll(email_accounts.get(users.get(j)));
                    for (int m = 0; m < next.size(); m++) {
                        if (emails.contains(next.get(m))) {
                            emails.addAll(next);
                            user = users.get(i);
                            flag = true;
                            break;
                        }

                    }
                    next.removeAll(next);
                }
                p++;
            }
            p = 0;
            if (flag) {
                result.addAll(emails);
                res.put(user, result);
            }
            flag = false;
            emails.removeAll(emails);
        }
        return (HashMap<String, List<String>>) res;
    }


}


