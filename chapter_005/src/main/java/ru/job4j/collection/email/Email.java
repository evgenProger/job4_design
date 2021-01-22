package ru.job4j.collection.email;

import java.util.*;

public class Email {



    public HashMap<String, List<String>> unionEmails(HashMap<String, List<String>> email_accounts) {
        Map<String, List<String>> res = new HashMap<>();
        List<String> result = new ArrayList<>();
        List<String> users = new ArrayList<>();
        users.addAll(email_accounts.keySet());
        List<String> my_list = new ArrayList<>();
        String user = null;
        Set<String> emails = new HashSet<>();
        List<String> next = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            emails.addAll(email_accounts.get(users.get(i)));
            for (int j = i + 1; j < users.size(); j++) {
                next.addAll(email_accounts.get(users.get(j)));
                for (int m = 0; m < next.size(); m++) {
                    if (emails.contains(next.get(m))) {
                        emails.addAll(next);
                        user = users.get(i);
                        break;
                    }
                }
                next.removeAll(next);
            }
            res.put(user, (List<String>) emails);
            emails.removeAll(emails);
        }
        return (HashMap<String, List<String>>) res;


    }

}
