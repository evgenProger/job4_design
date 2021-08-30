package ru.job4j.solid.dip.breakdip.exampleone;

/*
Давайте начнем с кода, который нарушает принцип.
Допустим, вы работаете в команде разработчиков программного обеспечения. Нам нужно реализовать проект.
На данный момент команда разработчиков программного обеспечения состоит из Backend Developer и Fronted
 И наш проект использует и то, и другое на протяжении всего процесса разработки
 */

public class Project {
    private BackEndDeveloper backEndDeveloper = new BackEndDeveloper();
    private FrontEndDeveloper frontEndDeveloper = new FrontEndDeveloper();

    public void implement() {
        backEndDeveloper.writeJava();
        frontEndDeveloper.writeJavascript();
    }
}

/*
Итак, как мы видим, класс Project - это модуль высокого уровня, и он зависит от модулей низкого уровня,
таких как BackEndDeveloper и FrontEndDeveloper. Фактически мы нарушаем первую часть принципа инверсии зависимостей.
    Кроме того, проверяя функцию реализации Project.class, мы понимаем, что методы writeJava и writeJavascript являются
методами, привязанными к соответствующим классам. Что касается объема проекта, это детали, поскольку в обоих случаях
они являются формами разработки. Таким образом, нарушается вторая часть принципа инверсии зависимостей.
 */
