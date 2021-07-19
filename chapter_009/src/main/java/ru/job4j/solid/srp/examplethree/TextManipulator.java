package ru.job4j.solid.srp.examplethree;

/*
Хотя код может показаться корректным, это не очень хороший пример SRP. Здесь у нас есть две обязанности:
манипулировать текстом и печатать его. Наличие метода, который печатает текст в этом классе, нарушает принцип
единой ответственности. Для этого нам следует создать еще один класс, который будет работать только с выводом текста
на печать.
 */

public class TextManipulator {

    private String text;

    public TextManipulator(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void appendText(String newText) {
        text = text.concat(newText);
    }

    public String findWordAndReplace(String word, String replacementWord) {
        if (text.contains(word)) {
            text = text.replace(word, replacementWord);
        }
        return text;
    }

    public String findWordAndDelete(String word) {
        if (text.contains(word)) {
            text = text.replace(word, "");
        }
        return text;
    }

    public void printText() {
        TextManipulator textManipulator = new TextManipulator("It's Text");
        System.out.println(textManipulator.getText());
    }
}
