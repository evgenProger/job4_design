package ru.job4j.collection.email;

import java.util.*;

public class EmailSolved2 {
    public static   Map<String, Set<String>> union(Map<String, Set<String>> accounts) {
        Map<String, Set<String>> res  = new LinkedHashMap<>();
        Map<String, String> temp = new HashMap<>();
        String name;
        Set<String> mails;
        for (Map.Entry<String, Set<String>> pair: accounts.entrySet()) {
            mails = pair.getValue();
            name = pair.getKey();
            for (String m: mails) {
                if (temp.containsKey(m)) {
                    name = temp.get(m);
                    break;
                }
            }
            for (String mail : mails) {
                temp.put(mail, name);
            }
        }
        for (Map.Entry<String, String> t : temp.entrySet()) {
            if (res.containsKey(t.getValue())) {
                res.get(t.getValue()).add(t.getKey());
            } else {
                Set<String> newSet = new HashSet<>();
                newSet.add(t.getKey());
                res.put(t.getValue(), newSet);
            }

        }
        return res;
    }
    public static Map<String, Set<String>> enterData() {
        Map<String, Set<String>> accounts = new LinkedHashMap<>();
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
