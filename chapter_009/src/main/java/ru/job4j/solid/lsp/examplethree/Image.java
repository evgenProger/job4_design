package ru.job4j.solid.lsp.examplethree;

public class Image {

}

class JpgImage extends Image { }

class Renderer {
    public Image render() {
        return null;
    };
}

class PhotoRenderer extends Renderer {
    public JpgImage render() {
        return null;
    }
}

/*
Здесь в методе render() дочернего класса, JpgImage объявлен типом возвращаемого значения, который в свою очередь
является подтипом Image, который возвращает метод родительского класса Renderer.
Не делай так!

https://habr.com/ru/post/559724/
 */


