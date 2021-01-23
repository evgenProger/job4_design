package ru.job4j.collection.email;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class EmailTest {
    @Test
    public void whenSomeUsersHaveSameEmailThenNewSize() {
        List<String> emails_Evgeny = new ArrayList<>();
        List<String> emails_Viktoria = new ArrayList<>();
        List<String> emails_Ekaterina = new ArrayList<>();
        List<String> emails_Masha = new ArrayList<>();
        emails_Evgeny.add("xxx@ya.ru");
        emails_Evgeny.add("foo@gmail.com");
        emails_Evgeny.add("lol@mail.ru");
        emails_Viktoria.add("foo@gmail.com");
        emails_Viktoria.add("ups@pisem.net");
        emails_Ekaterina.add("xyz@pisem.net");
        emails_Ekaterina.add("vasya@pupkin.com");
        emails_Masha.add("ups@pisem.net");
        emails_Masha.add("aaa@bbb.ru");
        HashMap<String, List<String>> emails_account = new HashMap<>();
        emails_account.put("Evgeny", emails_Evgeny);
        emails_account.put("Viktoria", emails_Viktoria);
        emails_account.put("Ekaterina", emails_Ekaterina);
        emails_account.put("Masha", emails_Masha);
        Email email = new Email();
        HashMap<String, List<String>> result = email.unionEmails(emails_account);
        List<String> users = new ArrayList<>();
        users.addAll(result.keySet());
        String user = users.get(0);
        assertThat(result.get(user).size(), is(5));

    }
    @Test
    public void whenSomeUsersHaveSameEmailThenSizeTwo() {
        List<String> emails_Evgeny = new ArrayList<>();
        List<String> emails_Viktoria = new ArrayList<>();
        List<String> emails_Ekaterina = new ArrayList<>();
        List<String> emails_Masha = new ArrayList<>();
        List<String> emails_Mary = new ArrayList<>();
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
        HashMap<String, List<String>> emails_account = new HashMap<>();
        emails_account.put("Evgeny", emails_Evgeny);
        emails_account.put("Viktoria", emails_Viktoria);
        emails_account.put("Ekaterina", emails_Ekaterina);
        emails_account.put("Masha", emails_Masha);
        emails_account.put("Mary", emails_Mary);
        Email email = new Email();
        HashMap<String, List<String>> result = email.unionEmails(emails_account);

        assertThat(result.size(), is(2));

    }

}