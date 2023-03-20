package Decorators;

import Pointer.Point;
import Shapes.Shape;

import java.awt.Graphics;
import java.awt.Color;

public class SelectedShapeDecorator implements Shape {

    private Shapes.Shape decoratee;

    public SelectedShapeDecorator(Shapes.Shape decoratee) {
        this.decoratee = decoratee;
    }
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        decoratee.draw(g);
    }

    @Override
    public Pointer.Point getPosition() {
        return decoratee.getPosition();
    }

    @Override
    public double getWidth() {
        return decoratee.getWidth();
    }

    @Override
    public double getHeight() {
        return decoratee.getHeight();
    }

    @Override
    public boolean intersects(Point point) {
        return decoratee.intersects(point);
    }

    @Override
    public void moveTo(Point point) {
        decoratee.moveTo(point);
    }

    @Override
    public void move(double dx, double dy) {
        decoratee.move(dx, dy);
    }

    @Override
    public void resizeTo(Point point) {
        decoratee.resizeTo(point);
    }

    @Override
    public Shape peel() {
        return decoratee;
    }
}
