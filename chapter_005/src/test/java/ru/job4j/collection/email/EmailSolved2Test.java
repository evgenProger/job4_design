package ru.job4j.collection.email;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class EmailSolved2Test {
    @Test
    public void whenSomeUsersHaveSameEmailThenNewSize() {
        Set<String> emails_Evgeny = new HashSet();
        Set<String> emails_Viktoria = new HashSet<>();
        Set<String> emails_Ekaterina = new HashSet<>();
        Set<String> emails_Masha = new HashSet<>();
        emails_Evgeny.add("xxx@ya.ru");
        emails_Evgeny.add("foo@gmail.com");
        emails_Evgeny.add("lol@mail.ru");
        emails_Viktoria.add("foo@gmail.com");
        emails_Viktoria.add("ups@pisem.net");
        emails_Ekaterina.add("xyz@pisem.net");
        emails_Ekaterina.add("vasya@pupkin.com");
        emails_Masha.add("ups@pisem.net");
        emails_Masha.add("aaa@bbb.ru");
        HashMap<String, Set<String>> emails_account = new HashMap<>();
        emails_account.put("Evgeny", emails_Evgeny);
        emails_account.put("Viktoria", emails_Viktoria);
        emails_account.put("Ekaterina", emails_Ekaterina);
        emails_account.put("Masha", emails_Masha);
        System.out.println("Входные данные" + emails_account);
        Map<String, Set<String>> result = EmailSolved2.union(emails_account);
        System.out.println("Выходные данные" + result);
        List<String> users = new ArrayList<>();
        users.addAll(result.keySet());
        String user = users.get(0);
        assertThat(result.get(user).size(), is(3));

    }
    @Test
    public void whenSomeUsersHaveSameEmailThenSizeTwo() {
        Set<String> emails_Evgeny = new HashSet();
        Set<String> emails_Viktoria = new HashSet<>();
        Set<String> emails_Ekaterina = new HashSet<>();
        Set<String> emails_Masha = new HashSet<>();
        Set<String> emails_Mary = new HashSet<>();
        emails_Evgeny.add("xxx@ya.ru");
        emails_Evgeny.add("foo@gmail.com");
        emails_Evgeny.add("lol@mail.ru");
        emails_Viktoria.add("foo@gmail.com");
        emails_Viktoria.add("ups@pisem.net");
        emails_Ekaterina.add("xyz@pisem.net");
        emails_Ekaterina.add("vasya@pupkin.com");
        emails_Masha.add("ups@pisem.net");
        emails_Masha.add("aaa@bbb.ru");
        emails_Mary.add("xyz@pisem.net");
        HashMap<String, Set<String>> emails_account = new HashMap<>();
        emails_account.put("Evgeny", emails_Evgeny);
        emails_account.put("Viktoria", emails_Viktoria);
        emails_account.put("Ekaterina", emails_Ekaterina);
        emails_account.put("Masha", emails_Masha);
        emails_account.put("Mary", emails_Mary);
        Email email = new Email();
        Map<String, Set<String>> result = email.unionEmails(emails_account);
        assertThat(result.size(), is(2));

    }

    @Test
    public void whenNewMethod() {
        Map<String, Set<String>> emailsAccount2 = new HashMap<>();
        Set<String> s1 = new HashSet<>();
        s1.add("Zasha");
        emailsAccount2.put("aaa@bbb.ru", s1);
        Set<String> s2 = new HashSet<>();
        s2.add("Zasha");
        s2.add("Viktoria");
        emailsAccount2.put("ups@pisem.net", s2);
        Set<String> s3 = new HashSet<>();
        s3.add("Ekaterina");
        emailsAccount2.put("vasya@pupkin.com", s3);
        Set<String> s4 = new HashSet<>();
        s4.add("Ekaterina");
        emailsAccount2.put("xyz@pisem.net", s4);
        Set<String> s5 = new HashSet<>();
        s5.add("Evgeny");
        emailsAccount2.put("lol@mail.ru", s5);
        Set<String> s6 = new HashSet<>();
        s6.add("Evgeny");
        emailsAccount2.put("xxx@ya.ru", s6);
        Set<String> s7 = new HashSet<>();
        s7.add("Evgeny");
        s7.add("Viktoria");
        emailsAccount2.put("foo@gmail.com", s7);
        Map<String, Set<String>> union = EmailSolved2.union(emailsAccount2);
        System.out.println(union);
    }
}


