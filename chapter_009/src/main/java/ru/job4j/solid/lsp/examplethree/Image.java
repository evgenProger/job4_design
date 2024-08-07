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


