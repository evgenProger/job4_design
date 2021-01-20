package ru.job4j.collection.email;

import java.util.*;

public class Email {
    private User user;


    public HashMap<User, List<Emails>> unionEmails(HashMap<User, List<Emails>> accounts) {
        Map<User, List<Emails>> res = new HashMap<>();
        List<Emails> emails_user1 = new ArrayList<>();
        List<Emails> emails_user2 = new ArrayList<>();
        Set<User> users = accounts.keySet();
        Iterator<User> it = users.iterator();
        while (it.hasNext()) {
            emails_user1.addAll(accounts.get(it.next().getId()));
            emails_user2.addAll(accounts.get(it.next().getId()));

        }


        return (HashMap<User, List<Emails>>) res;

    }




    public static class Emails {

        public Emails(String emails) {
        }
    }
}
