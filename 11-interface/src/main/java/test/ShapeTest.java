package test;

abstract class Shape {
    public static final double PI = 3.14;

    public abstract double perimeter();

    public abstract double area();

    public abstract void fillColor(String color);

}

class Circle extends Shape {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double perimeter() {
        return 2 * PI * radius;
    }

    @Override
    public double area() {
        return PI * radius * radius;
    }

    @Override
    public void fillColor(String color) {
        System.out.println("circle is " + color);
    }
}

class Rectangle extends Shape {

    private double height;
    private double width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public double perimeter() {
        return 2 * (height + width);
    }

    @Override
    public double area() {
        return height + width;
    }

    @Override
    public void fillColor(String color) {
        System.out.println("rectangle is " + color);
    }
}

public class ShapeTest {

    public static void main(String[] args) {

        Shape circle = new Circle(2);
        System.out.println(circle.area());
        System.out.println(circle.area());
        circle.fillColor("red");

        Shape rectangle = new Rectangle(2, 3);
        System.out.println(rectangle.area());
        System.out.println(rectangle.perimeter());
        rectangle.fillColor("yellow");
    }
}
