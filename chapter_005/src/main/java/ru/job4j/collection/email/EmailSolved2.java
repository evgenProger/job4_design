package ru.job4j.collection.email;

import java.util.*;

public class EmailSolved2 {
    public static   Map<String, Set<String>> union(Map<String, Set<String>> email_accounts) {
        Map<String, Set<String>> res = new LinkedHashMap<>();
        for (Map.Entry<String, Set<String>> accounts: email_accounts.entrySet()) {
            String unionUser = null;
            Set<String> unionEmails = null;
            for (Map.Entry<String, Set<String>> accounts_res: res.entrySet()) {
                for (String mail: accounts.getValue()) {
                    if (accounts_res.getValue().contains(mail)) {
                        unionUser = accounts_res.getKey();
                        unionEmails = email_accounts.get(accounts.getKey());
                        break;
                    }
                }
                if (unionUser != null) {
                    break;
                }

            }
            if (unionUser != null) {
                res.get(unionUser).addAll(unionEmails);
            }
            else {
                res.put(accounts.getKey(), new LinkedHashSet<>(accounts.getValue()));
            }

        }
        return res;
    }

    public static Map<String, Set<String>> enterData() {
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
        Map<String, Set<String>> stringSetMap = EmailSolved2.enterData();
        Map<String, Set<String>> out = EmailSolved2.union(stringSetMap);
        System.out.println(out);
    }
}
