package ru.job4j.solid.isp.menu;

public interface UpdateMenu {
    /**
     * Метод возвращает ключ опции
     * @return ключ
     */
    int key();

    /**
     * Метод возвращает информацию о данном пункте меню
     *
     * @ Строка меню
     */
    String info();

    /**
     * Основной метод
     *
     * @param input   объект типа Input
     * @param menu объект типа Menu
     */
    void execute(Input input, MenuAction menu);
}
