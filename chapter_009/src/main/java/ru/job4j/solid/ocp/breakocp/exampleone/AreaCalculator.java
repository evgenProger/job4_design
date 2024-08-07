package ru.job4j.solid.ocp.breakocp.exampleone;

public class AreaCalculator {
    public double calculateRectangleArea(Rectangle rectangle) {
        return rectangle.length * rectangle.width;
    }
    public double calculateCircleArea(Circle circle) {
        return (22 / 7) * circle.radius * circle.radius;
    }
}
