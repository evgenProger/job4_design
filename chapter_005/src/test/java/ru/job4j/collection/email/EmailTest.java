package ru.job4j.collection.email;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class EmailTest {
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
        Email email = new Email();
        Map<String, Set<String>> result = email.unionEmails(emailsAccount);
        System.out.println("Выходные данные" + result);
        List<String> users = new ArrayList<>();
        users.addAll(result.keySet());
        String user = users.get(0);
        assertThat(result.get(user).size(), is(5));

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

}