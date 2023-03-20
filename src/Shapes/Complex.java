package Shapes;
import Pointer.Point;
import Shapes.Shape;

import java.awt.Graphics;
import java.util.ArrayList;

public class Complex implements Shape {

    private Point center;
    private double length;
    private double r;
    private Shape circle;
    private Shape square;
    private ArrayList<Shape> shapes = new ArrayList<>();

    public Complex(double x, double y, double length) {
        center = new Point(x,y);
        this.length = length;
        shapes.add(new Circle(center, length));
        shapes.add(new Square(center, length));
    }

    public Complex(Point point, double length) {
        this(point.getX(), point.getY(), length);
    }

    @Override
    public void draw(Graphics g) {
       // baka in cirkeln i square
       g.drawOval((int)(0.5+center.getX()-r), (int)(0.5+center.getY()-r), (int)(0.5+2*r), (int)(0.5+2*r));
       g.drawRect((int)(0.5+center.getX()-length), (int)(0.5+center.getY()-length), (int)(0.5+2*length), (int)(0.5+2*length));
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
        center.moveTo(point);
    }

    @Override
    public void move(double dx, double dy) {
        center.move(dx, dy);
    }

    @Override
    public void resizeTo(Point point) {
        length = center.distanceTo(point);
    }

    @Override
    public Shape peel() {
       return this;
       
    }


}
