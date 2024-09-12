/**
 * @author markymouseee
 **/

package oop_homework_problem;

abstract class Shape {
     public abstract double calculateArea();
}

class Circle extends Shape{
    private double radius;

    public Circle(double radius){
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape{
    private double width;
    private double height;

    public Rectangle(double width, double height){
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }
}

class Square extends Shape{
    private double side;

    public Square(double side){
        this.side = side;
    }

    @Override
    public double calculateArea() {
        return side * side;
    }
}

class MainOfShape{
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];

        shapes[0] = new Circle(7);
        shapes[1] = new Rectangle(8, 10);
        shapes[2] = new Square(6);

        for(Shape shape: shapes){
            System.out.println("Area of each shapes: " + shape.calculateArea());
        }

    }
}