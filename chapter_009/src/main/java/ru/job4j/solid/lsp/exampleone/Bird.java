package ru.job4j.solid.lsp.exampleone;

public class Bird {
    public void fly() { }
}

/*
 // Утка умеет летать, потому что это птица
 */
class Duck extends Bird {
    @Override
    public void fly() {
        super.fly();
    }

}

/*
Страус - это птица, но он не может летать, класс Ostrich является подтипом класса Bird,
но он не должен иметь возможность использовать метод fly, это означает, что мы нарушаем принцип LSP.
 */
class Ostrich extends Bird {
    @Override
    public void fly() {
        super.fly();
    }
}
