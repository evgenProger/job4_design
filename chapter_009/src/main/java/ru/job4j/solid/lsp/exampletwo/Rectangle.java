package ru.job4j.solid.lsp.exampletwo;

public class Rectangle {

    private int length;
    private int breadth;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getBreadth() {
        return breadth;
    }

    public void setBreadth(int breadth) {
        this.breadth = breadth;
    }

    public int getArea() {
        return this.length * this.breadth;
    }
}

class Square extends Rectangle {
    @Override
    public void setLength(int length) {
        super.setLength(length);
        super.setBreadth(length);
    }

    @Override
    public void setBreadth(int breadth) {
        super.setBreadth(breadth);
        super.setLength(breadth);
    }
}
