package ru.job4j.collection.email;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class EmailTest {
    @Test
    public void whenSomeUsersHaveSameEmailThenUnion() {
        User user1 = new User("Evgeny", 25);
        User user2 = new User("Vika", 26);
        User user3 = new User("Bob", 35);
        List<Email.Emails> emails_user1 = new ArrayList<>();
        List<Email.Emails> emails_user2 = new ArrayList<>();
        List<Email.Emails> emails_user3 = new ArrayList<>();
        Map<User, Email.Emails> accounts = new HashMap<>();
        emails_user1.add(new Email.Emails("xxx@ya.ru"));
        emails_user1.add(new Email.Emails("foo@gmail.com"));
        emails_user1.add(new Email.Emails("lol@mail.ru"));
        emails_user2.add(new Email.Emails("foo@gmail.com"));
        emails_user2.add(new Email.Emails("ups@pisemnet.net"));
        emails_user3.add(new Email.Emails("xyz@pisem.net"));
        emails_user3.add(new Email.Emails("vasya@pupkin.com"));
        accounts.put(user1, (Email.Emails) emails_user1);
        accounts.put(user2, (Email.Emails) emails_user2);
        accounts.put(user3, (Email.Emails) emails_user3);



        }

}