package ru.job4j.solid.ocp.breakocp.exampleone;
/*
Затем мы создаем класс для вычисления площади этого прямоугольника, который имеет метод calculateRectangleArea (),
который принимает прямоугольник в качестве входного параметра и вычисляет его площадь.

Однако обратите внимание, что в разработки нашего решения есть недостатки.

Допустим, у нас есть новый пятиугольник. В этом случае мы снова закончим модификацией класса AreaCalculator.
По мере роста типов фигур это становится все более беспорядочным, поскольку AreaCalculator продолжает меняться,
и любые потребители этого класса должны будут продолжать обновлять свои библиотеки, которые содержат AreaCalculator.
 В результате класс AreaCalculator не будет окончательно определен (завершен), поскольку каждый раз, когда появляется
 новая форма, она будет изменяться. Так что эта конструкция не закрыта для модификации.

Также обратите внимание, что этот дизайн не является расширяемым, то есть что, если сложные формы будут появляться,
AreaCalculator должен будет продолжать добавлять свою вычислительную логику в новые методы. На самом деле
мы не расширяем объем форм; скорее, мы просто делаем поштучное (побитовое) решение для каждой добавляемой формы.

https://www.javabrahman.com/programming-principles/open-closed-principle-with-examples-in-java/
 */

public class AreaCalculator {
    public double calculateRectangleArea(Rectangle rectangle){
        return rectangle.length *rectangle.width;
    }
    public double calculateCircleArea(Circle circle){
        return (22/7) * circle.radius*circle.radius;
    }
}