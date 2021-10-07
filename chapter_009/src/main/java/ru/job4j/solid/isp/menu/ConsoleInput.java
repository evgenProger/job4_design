package ru.job4j.solid.isp.menu;

import java.util.List;
import java.util.Scanner;

public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

    /*
     * Метод сравнивает введенный пользователем ключ с ключами(пунктами) меню и если введенный ключ(номер пункта)
     * совпадает с имеющимся ключом меню, ывыходим из цикла и возвращаем ключ.
     * @param question вводимый пользователем ключ(пункт меню)
     * @param range    динамический список хранящий ключи(пункты) нашего меню
     * @return возвращет ключ введенный пользователем, если введеный ключ и имеющийся в списке range совпадают.
     * Это значит ключ введет правильно и такой пункт существует
     */
    public int ask(String question, List<Integer> range) {
        int key = Integer.parseInt(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            throw new MenuOutException("Некорректный ввод");
        }
        return key;
    }

}
