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

    public Map<String, Set<String>> enterData() {
        Map<String, Set<String>> accounts = new HashMap<>();
        Scanner in = new Scanner(System.in);
        String value = in.nextLine();
        while (!value.equals("end")) {
            String[] s = value.split(" ");
            String user = s[0];
            Set<String> emails = new HashSet<>();
            for (int i = 1; i < s.length; i++) {
                emails.add(s[i]);
            }
            accounts.put(user, emails);
            value = in.nextLine();
        }
        return accounts;
    }

    public static void main(String[] args) {
       Email email = new Email();
        Map<String, Set<String>> stringSetMap = email.enterData();
        Map<String, Set<String>> out = email.unionEmails(stringSetMap);
        System.out.println(out);
    }

}


