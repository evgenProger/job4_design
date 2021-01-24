package ru.job4j.collection.email;

import java.util.*;

public class Email {



    public HashMap<String, List<String>> unionEmails(HashMap<String, List<String>> email_accounts) {
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
        int j= 1;
        int k = 0;
        user = users.get(0);
        res.put(user, (Set<String>) email_accounts.get(users.get(i)));
        while (i < users.size()) {
            previous.addAll(res.get(user));
            next.addAll(email_accounts.get(users.get(j)));
            for (int m = 0; m < previous.size(); m++) {
                for (int n = 0; n < next.size(); n++) {
                    if (previous.get(m).equals(next.get(n))) {
                        res.put(user, (Set<String>) next);
                    }
                }
            }
        }





























        /*  while (i < users.size()) {
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
            i++;
            emails.removeAll(emails);
        }
       */
        return (HashMap<String, List<String>>) res;
    }


}


