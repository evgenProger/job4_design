package ru.job4j.collection.email;

import java.util.*;

public class Email {

    public Map<String, Set<String>> unionEmails(Map<String, Set<String>> email_accounts) {
        return   fillingMap(email_accounts, new HashMap<>());
    }

    public Map<String, Set<String>> fillingMap(Map<String, Set<String>> email_accounts, Map<String, Set<String>> res) {
        if (email_accounts.isEmpty()) {
            return res;
        }
        for (String user: email_accounts.keySet()) {
            for (String user_res: res.keySet()) {
               if (res.get(user_res).stream().anyMatch(u -> email_accounts.get(user).contains(u))) {
                   res.get(user_res).addAll(email_accounts.get(user));
                   email_accounts.remove(user);
                   return fillingMap(email_accounts, res);
               }
            }
        }
         String user1 = email_accounts.keySet().stream().findFirst().get();
        res.put(user1, email_accounts.get(user1));
        email_accounts.remove(user1);
        return fillingMap(email_accounts, res);
    }
}


