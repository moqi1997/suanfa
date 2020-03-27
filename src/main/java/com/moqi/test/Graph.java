package com.moqi.test;

/**
 * @author moqi
 * @date 2020/3/24 18:00
 */
public interface Graph {
    public void drawing();
}

class Rectangle implements Graph {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public Rectangle() {
    }

    @Override
    public void drawing() {
        System.out.println("做一个矩形");
    }
}
class Circle implements Graph {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle() {
    }

    @Override
    public void drawing() {
        System.out.println("做一个圆形");
    }
}
class Triangle implements Graph{
    private double a;
    private double b;
    private double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Triangle() {
    }

    @Override
    public void drawing() {
        System.out.println("做一个三角形");
    }
}
class Client {
    public void myDrawing(Graph graph) {
        graph.drawing();
    }
}
class ClientDemo {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        Circle circle = new Circle();
        Triangle triangle = new Triangle();
        Client client = new Client();
        client.myDrawing(rectangle);
        client.myDrawing(circle);
        client.myDrawing(triangle);
    }
}