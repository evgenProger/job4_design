package ru.job4j.collection.email;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class EmailSolved2Test {
    @Test
    public void whenSomeUsersHaveSameEmailThenNewSize() {
        Set<String> emailsEvgeny = new HashSet();
        Set<String> emailsViktoria = new HashSet<>();
        Set<String> emailsEkaterina = new HashSet<>();
        Set<String> emailsMasha = new HashSet<>();
        emailsEvgeny.add("xxx@ya.ru");
        emailsEvgeny.add("foo@gmail.com");
        emailsEvgeny.add("lol@mail.ru");
        emailsViktoria.add("foo@gmail.com");
        emailsViktoria.add("ups@pisem.net");
        emailsEkaterina.add("xyz@pisem.net");
        emailsEkaterina.add("vasya@pupkin.com");
        emailsMasha.add("ups@pisem.net");
        emailsMasha.add("aaa@bbb.ru");
        HashMap<String, Set<String>> emailsAccount = new HashMap<>();
        emailsAccount.put("Evgeny", emailsEvgeny);
        emailsAccount.put("Viktoria", emailsViktoria);
        emailsAccount.put("Ekaterina", emailsEkaterina);
        emailsAccount.put("Masha", emailsMasha);
        System.out.println("Входные данные" + emailsAccount);
        Map<String, Set<String>> result = EmailSolved2.union(emailsAccount);
        System.out.println("Выходные данные" + result);
        List<String> users = new ArrayList<>();
        users.addAll(result.keySet());
        String user = users.get(0);
        assertThat(result.get(user).size(), is(3));

    }
    @Test
    public void whenSomeUsersHaveSameEmailThenSizeTwo() {
        Set<String> emailsEvgeny = new HashSet();
        Set<String> emailsViktoria = new HashSet<>();
        Set<String> emailsEkaterina = new HashSet<>();
        Set<String> emailsMasha = new HashSet<>();
        Set<String> emailsMary = new HashSet<>();
        emailsEvgeny.add("xxx@ya.ru");
        emailsEvgeny.add("foo@gmail.com");
        emailsEvgeny.add("lol@mail.ru");
        emailsViktoria.add("foo@gmail.com");
        emailsViktoria.add("ups@pisem.net");
        emailsEkaterina.add("xyz@pisem.net");
        emailsEkaterina.add("vasya@pupkin.com");
        emailsMasha.add("ups@pisem.net");
        emailsMasha.add("aaa@bbb.ru");
        emailsMary.add("xyz@pisem.net");
        HashMap<String, Set<String>> emailsAccount = new HashMap<>();
        emailsAccount.put("Evgeny", emailsEvgeny);
        emailsAccount.put("Viktoria", emailsViktoria);
        emailsAccount.put("Ekaterina", emailsEkaterina);
        emailsAccount.put("Masha", emailsMasha);
        emailsAccount.put("Mary", emailsMary);
        Email email = new Email();
        Map<String, Set<String>> result = email.unionEmails(emailsAccount);
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


