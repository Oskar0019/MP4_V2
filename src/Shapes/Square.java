package Shapes;

import java.awt.Graphics;

import Pointer.Point;

public class Square implements Shape {

    private Point center;
    private double length;
 


    public Square(Point point, double length) {
        
        this(point.getX(), point.getY(), length);
      
    } 

    public Square(double x, double y, double length) {
        center = new Point(x, y);
        this.length = length;
        
    }

    @Override
    public void draw(Graphics g) {
        g.drawRect((int)(0.5+center.getX()-length/2), (int)(0.5+center.getY()-length/2), (int)(0.5+length), (int)(0.5+length));
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
        length = center.distanceTo(point)*2;
    }

    @Override
    public Shape peel() {
       return this;
    }







    
}
