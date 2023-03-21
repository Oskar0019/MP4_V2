package Shapes;

import Pointer.Point;
import Shapes.Shape;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Complex implements Shape {

    private Point center;
    private double length;
    private double r;
    private Shape circle;
    private Shape square;
    private ArrayList<Shape> shapes = new ArrayList<>();

    public Complex(double x, double y, double length, double r) {
        center = new Point(x, y);
        this.length = length;
        this.r = r;
        circle = new Circle(center, r);
        square = new Square(center, length);
        shapes.add(circle);
        shapes.add(square);
    }

    public Complex(Point point, double length, double r) {
        this(point.getX(), point.getY(), length, r);
    }

    public Shape getCircle() {
        return circle;
    }

    public Shape getSquare() {
        return square;
    }

    @Override
    public void draw(Graphics g) {
        for (int i = 0; i < shapes.size(); i++) {
            shapes.get(i).draw(g);
        }
    }

    @Override
    public Point getPosition() {
        return center;
    }

    @Override
    public double getWidth() {
        return length;
    }

    @Override
    public double getHeight() {
        return length;
    }

    @Override
    public boolean intersects(Point point) {
        return center.distanceTo(point) < length;
    }

    @Override
    public void moveTo(Point point) {
        for (int i = 0; i < shapes.size(); i++) {
            shapes.get(i).moveTo(point);
        }
    }

    @Override
    public void move(double dx, double dy) {
        for (int i = 0; i < shapes.size(); i++) {
            shapes.get(i).move(dx, dy);
        }
    }

    @Override
    public void resizeTo(Point point) {
        for (int i = 0; i < shapes.size(); i++) {
            shapes.get(i).resizeTo(point);
        }
    }

    @Override
    public Shape peel() {
        return this;

    }

}
